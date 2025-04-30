//package com.company.api.googleCloudStorage;
//
//import com.google.auth.Credentials;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.*;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//public class GenerateV4PutObjectSignedUrl {
//    /**
//     * Signing a URL requires Credentials which implement ServiceAccountSigner. These can be set
//     * explicitly using the Storage.SignUrlOption.signWith(ServiceAccountSigner) option. If you don't,
//     * you could also pass a service account signer to StorageOptions, i.e.
//     * StorageOptions().newBuilder().setCredentials(ServiceAccountSignerCredentials). In this example,
//     * neither of these options are used, which means the following code only works when the
//     * credentials are defined via the environment variable GOOGLE_APPLICATION_CREDENTIALS, and those
//     * credentials are authorized to sign a URL. See the documentation for Storage.signUrl for more
//     * details.
//     */
//    public static void generateV4PutObjectSignedUrl(
//            String projectId, String bucketName, String objectName) throws StorageException, FileNotFoundException, IOException {
//        // projectId = "my-project-id";
//        // bucketName = "my-bucket";
//        // objectName = "my-object";
//        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\islam\\Documents\\psyched-circuit-451220-v3-e7d074c0e5d1.json"));
//        Storage storage = StorageOptions.newBuilder()
//                .setCredentials(credentials)
//                .setProjectId(projectId)
//                .build().getService();
//
//        // Define Resource
//        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucketName, objectName)).build();
//
//        // Generate Signed URL
//        Map<String, String> extensionHeaders = new HashMap<>();
//        extensionHeaders.put("Content-Type", "application/octet-stream");
//
//        URL url =
//                storage.signUrl(
//                        blobInfo,
//                        15,
//                        TimeUnit.MINUTES,
//                        Storage.SignUrlOption.httpMethod(HttpMethod.PUT),
//                        Storage.SignUrlOption.withExtHeaders(extensionHeaders),
//                        Storage.SignUrlOption.withV4Signature());
//
//        System.out.println("Generated PUT signed URL:");
//        System.out.println(url);
//        System.out.println("You can use this URL with any user agent, for example:");
//        System.out.println("curl -X PUT -H 'Content-Type: application/octet-stream' --upload-file my-file '" + url + "'");
//    }
//}