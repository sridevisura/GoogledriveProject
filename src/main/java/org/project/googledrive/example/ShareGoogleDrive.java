package org.project.googledrive.example;

import java.io.IOException;
import org.project.googledrive.utils.GoogleDriveUtils;
//import org.o7planning.googledrive.utils.GoogleDriveUtils;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;

public class ShareGoogleDrive {

    // Public a Google File/Folder.
    public static Permission createPublicPermission(String googleFileId) throws IOException {
        // All values: user - group - domain - anyone
        String permissionType = "anyone";
        // All values: organizer - owner - writer - commenter - reader
        String permissionRole = "owner";

        Permission newPermission = new Permission();
        newPermission.setType(permissionType);
        newPermission.setRole(permissionRole);

        Drive driveService = GoogleDriveUtils.getDriveService();
        return driveService.permissions().create(googleFileId, newPermission).execute();
    }

    public static Permission createPermissionForEmail(String googleFileId, String googleEmail) throws IOException {
        // All values: user - group - domain - anyone
        String permissionType = "user"; // Valid: user, group
        // organizer - owner - writer - commenter - reader
        String permissionRole = "owner";
      // String PermissiontransferOwnership ="true";

        Permission newPermission = new Permission();
        newPermission.setType(permissionType);
        newPermission.setRole(permissionRole);
//newPermission.set(PermissiontransferOwnership)
        newPermission.setEmailAddress(googleEmail);

        Drive driveService = GoogleDriveUtils.getDriveService();
        return driveService.permissions().create(googleFileId, newPermission).execute();
    }

    public static void main(String[] args) throws IOException {
       String googleFileId1 = "newfile.txt  ";
       String googleEmail = "sridevi.sura@gmail.com";

        // Share for a User
      createPermissionForEmail(googleFileId1, googleEmail);

        //String googleFileId2 = "some-google-file-id-2";

        // Share for everyone
      //  createPublicPermission(googleFileId2);

        System.out.println("Done!");
    }

}
