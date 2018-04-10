package com.react_native_neon_module;

/**
 * @author rajeevkumar
 * @version 1.0
 * @since 4/4/18
 */
public class NeonReactParams {
    private int requestCode;
    private int libraryMode;
    private int numberOfPhotos;
    private boolean tagEnabled;
    private int cameraFacing;
    private int cameraOrientation;
    private int cameraViewType;
    private boolean flashEnabled = true;
    private boolean cameraSwitchingEnabled;
    private boolean cameraToGallerySwitchEnabled;
    private int galleryViewType;
    private boolean enableFolderStructure = true;
    private boolean galleryToCameraSwitchEnabled;
    private boolean isRestrictedExtensionJpgPngEnabled = true;
    private boolean selectVideos;
    private boolean videoCaptureEnabled;
    private boolean enableImageEditing;
    private boolean locationRestrictive;
    private boolean hideCameraButtonInNeutral;
    private boolean hideGalleryButtonInNeutral;
    private String imageTagListJson;
    private String alreadyAddedImagesJson;
    private boolean hasOnlyProfileTag;
    private String profileTagName;

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getLibraryMode() {
        return libraryMode;
    }

    public void setLibraryMode(int libraryMode) {
        this.libraryMode = libraryMode;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public void setNumberOfPhotos(int numberOfPhotos) {
        this.numberOfPhotos = numberOfPhotos;
    }

    public boolean isTagEnabled() {
        return tagEnabled;
    }

    public void setTagEnabled(boolean tagEnabled) {
        this.tagEnabled = tagEnabled;
    }

    public int getCameraFacing() {
        return cameraFacing;
    }

    public void setCameraFacing(int cameraFacing) {
        this.cameraFacing = cameraFacing;
    }

    public int getCameraOrientation() {
        return cameraOrientation;
    }

    public void setCameraOrientation(int cameraOrientation) {
        this.cameraOrientation = cameraOrientation;
    }

    public int getCameraViewType() {
        return cameraViewType;
    }

    public void setCameraViewType(int cameraViewType) {
        this.cameraViewType = cameraViewType;
    }

    public boolean isFlashEnabled() {
        return flashEnabled;
    }

    public void setFlashEnabled(boolean flashEnabled) {
        this.flashEnabled = flashEnabled;
    }

    public boolean isCameraSwitchingEnabled() {
        return cameraSwitchingEnabled;
    }

    public void setCameraSwitchingEnabled(boolean cameraSwitchingEnabled) {
        this.cameraSwitchingEnabled = cameraSwitchingEnabled;
    }

    public boolean isCameraToGallerySwitchEnabled() {
        return cameraToGallerySwitchEnabled;
    }

    public void setCameraToGallerySwitchEnabled(boolean cameraToGallerySwitchEnabled) {
        this.cameraToGallerySwitchEnabled = cameraToGallerySwitchEnabled;
    }

    public int getGalleryViewType() {
        return galleryViewType;
    }

    public void setGalleryViewType(int galleryViewType) {
        this.galleryViewType = galleryViewType;
    }

    public boolean isEnableFolderStructure() {
        return enableFolderStructure;
    }

    public void setEnableFolderStructure(boolean enableFolderStructure) {
        this.enableFolderStructure = enableFolderStructure;
    }

    public boolean isGalleryToCameraSwitchEnabled() {
        return galleryToCameraSwitchEnabled;
    }

    public void setGalleryToCameraSwitchEnabled(boolean galleryToCameraSwitchEnabled) {
        this.galleryToCameraSwitchEnabled = galleryToCameraSwitchEnabled;
    }

    public boolean isRestrictedExtensionJpgPngEnabled() {
        return isRestrictedExtensionJpgPngEnabled;
    }

    public void setRestrictedExtensionJpgPngEnabled(boolean restrictedExtensionJpgPngEnabled) {
        isRestrictedExtensionJpgPngEnabled = restrictedExtensionJpgPngEnabled;
    }

    public boolean isSelectVideos() {
        return selectVideos;
    }

    public void setSelectVideos(boolean selectVideos) {
        this.selectVideos = selectVideos;
    }

    public boolean isVideoCaptureEnabled() {
        return videoCaptureEnabled;
    }

    public void setVideoCaptureEnabled(boolean videoCaptureEnabled) {
        this.videoCaptureEnabled = videoCaptureEnabled;
    }

    public boolean isEnableImageEditing() {
        return enableImageEditing;
    }

    public void setEnableImageEditing(boolean enableImageEditing) {
        this.enableImageEditing = enableImageEditing;
    }

    public boolean isLocationRestrictive() {
        return locationRestrictive;
    }

    public void setLocationRestrictive(boolean locationRestrictive) {
        this.locationRestrictive = locationRestrictive;
    }

    public boolean isHideCameraButtonInNeutral() {
        return hideCameraButtonInNeutral;
    }

    public void setHideCameraButtonInNeutral(boolean hideCameraButtonInNeutral) {
        this.hideCameraButtonInNeutral = hideCameraButtonInNeutral;
    }

    public boolean isHideGalleryButtonInNeutral() {
        return hideGalleryButtonInNeutral;
    }

    public void setHideGalleryButtonInNeutral(boolean hideGalleryButtonInNeutral) {
        this.hideGalleryButtonInNeutral = hideGalleryButtonInNeutral;
    }

    public String getImageTagListJson() {
        return imageTagListJson;
    }

    public void setImageTagListJson(String imageTagListJson) {
        this.imageTagListJson = imageTagListJson;
    }

    public String getAlreadyAddedImagesJson() {
        return alreadyAddedImagesJson;
    }

    public void setAlreadyAddedImagesJson(String alreadyAddedImagesJson) {
        this.alreadyAddedImagesJson = alreadyAddedImagesJson;
    }

    public boolean isHasOnlyProfileTag() {
        return hasOnlyProfileTag;
    }

    public void setHasOnlyProfileTag(boolean hasOnlyProfileTag) {
        this.hasOnlyProfileTag = hasOnlyProfileTag;
    }

    public String getProfileTagName() {
        return profileTagName;
    }

    public void setProfileTagName(String profileTagName) {
        this.profileTagName = profileTagName;
    }
}