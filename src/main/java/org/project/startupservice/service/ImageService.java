package org.project.startupservice.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.project.startupservice.exception.ImageUploadException;
import org.project.startupservice.properties.MinioProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final MinioClient minioClient;
    private final MinioProperties minioProperties;

    public String uploadImage(MultipartFile file) {
        if (file.isEmpty() || file.getOriginalFilename() == null) {
            throw new ImageUploadException("File is empty");
        }

        String fileName = generateFileName(file);

        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new ImageUploadException("Image upload failed");
        }

        saveImage(inputStream, fileName);
        return fileName;
    }

    private String generateFileName(MultipartFile file) {
        if (file.isEmpty() || file.getOriginalFilename() == null) {
            throw new ImageUploadException("File is empty");
        }
        String extension = getExtension(file.getOriginalFilename());
        return UUID.randomUUID() + extension;
    }

    private String getExtension(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")) {
            return extension;
        } else throw new ImageUploadException("Extension of image is failed");
    }

    @SneakyThrows
    private void saveImage(InputStream inputStream, String fileName) {
        boolean found = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(minioProperties.getBucket())
                        .build()
        );

        if (!found) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(minioProperties.getBucket())
                            .build()
            );
        }

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(minioProperties.getBucket())
                        .object(fileName)
                        .stream(inputStream, inputStream.available(), -1)
                        .build()
        );
    }
}
