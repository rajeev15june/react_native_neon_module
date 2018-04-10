package com.react_native_neon_module;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.gaadi.neon.PhotosLibrary;
import com.gaadi.neon.enumerations.CameraFacing;
import com.gaadi.neon.enumerations.CameraOrientation;
import com.gaadi.neon.enumerations.CameraType;
import com.gaadi.neon.enumerations.GalleryType;
import com.gaadi.neon.enumerations.LibraryMode;
import com.gaadi.neon.interfaces.ICameraParam;
import com.gaadi.neon.interfaces.IGalleryParam;
import com.gaadi.neon.interfaces.INeutralParam;
import com.gaadi.neon.interfaces.LivePhotosListener;
import com.gaadi.neon.interfaces.OnImageCollectionListener;
import com.gaadi.neon.model.ImageTagModel;
import com.gaadi.neon.model.NeonResponse;
import com.gaadi.neon.model.PhotosMode;
import com.gaadi.neon.util.CustomParameters;
import com.gaadi.neon.util.FileInfo;
import com.gaadi.neon.util.NeonImagesHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author rajeevkumar
 * @version 1.0
 * @since 4/4/18
 */
public class NeonModule extends ReactContextBaseJavaModule {


    public NeonModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "NeonModule";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        return constants;
    }

    @ReactMethod
    private void collectPhotos(int type, String neonReactParamsJson, Callback callback){
        if (type == 0){
            openNeutral(neonReactParamsJson, callback);
        }else if (type == 1){
            openCamera(neonReactParamsJson, callback);
        }else if (type == 2){
            openGallery(neonReactParamsJson, callback);
        }

    }

    private void openCamera(final String neonReactParamsJson, final Callback callback) {
        try {
            final NeonReactParams params = getNeonReactParams(neonReactParamsJson);
            PhotosLibrary.collectPhotos(params.getRequestCode(), getCurrentActivity(), params.getLibraryMode() == 0 ? LibraryMode.Relax : LibraryMode.Restrict, PhotosMode.setCameraMode().setParams(
                    new ICameraParam() {
                        @Override
                        public CameraFacing getCameraFacing() {
                            return params.getCameraFacing() == 0 ? CameraFacing.back : CameraFacing.front;
                        }

                        @Override
                        public CameraOrientation getCameraOrientation() {
                            return params.getCameraOrientation() == 0 ? CameraOrientation.landscape : CameraOrientation.portrait;
                        }

                        @Override
                        public boolean getFlashEnabled() {
                            return params.isFlashEnabled();
                        }

                        @Override
                        public boolean getCameraSwitchingEnabled() {
                            return params.isCameraSwitchingEnabled();
                        }

                        @Override
                        public boolean getVideoCaptureEnabled() {
                            return params.isVideoCaptureEnabled();
                        }

                        @Override
                        public CameraType getCameraViewType() {
                            return params.getCameraViewType() == 0 ? CameraType.normal_camera : CameraType.gallery_preview_camera;
                        }

                        @Override
                        public boolean cameraToGallerySwitchEnabled() {
                            return params.isCameraToGallerySwitchEnabled();
                        }

                        @Override
                        public int getNumberOfPhotos() {
                            return params.getNumberOfPhotos();
                        }

                        @Override
                        public boolean getTagEnabled() {
                            return params.isTagEnabled();
                        }

                        @Override
                        public List<ImageTagModel> getImageTagsModel() {
                            return getImageTagModels(params.getImageTagListJson());
                        }

                        @Override
                        public List<FileInfo> getAlreadyAddedImages() {
                            return getAlreadyAddedImagesList(params.getAlreadyAddedImagesJson());
                        }

                        @Override
                        public boolean enableImageEditing() {
                            return params.isEnableImageEditing();
                        }

                        @Override
                        public CustomParameters getCustomParameters() {
                            CustomParameters.CustomParametersBuilder builder = new CustomParameters.CustomParametersBuilder();
                            builder.setLocationRestrictive(params.isLocationRestrictive());
                            builder.sethideCameraButtonInNeutral(params.isHideCameraButtonInNeutral());
                            builder.setHideGalleryButtonInNeutral(params.isHideGalleryButtonInNeutral());
                            return builder.build();
                        }
                    }), new OnImageCollectionListener() {
                @Override
                public void imageCollection(NeonResponse neonResponse) {
                    callback.invoke(getImageCollection(neonResponse));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void openGallery(final String neonReactParamsJson, final Callback callback) {
        try {
            final NeonReactParams params = getNeonReactParams(neonReactParamsJson);
            PhotosLibrary.collectPhotos(params.getRequestCode(), getCurrentActivity(), params.getLibraryMode() == 0 ? LibraryMode.Relax : LibraryMode.Restrict, PhotosMode.setGalleryMode().setParams(new IGalleryParam() {
                @Override
                public boolean selectVideos() {
                    return params.isSelectVideos();
                }

                @Override
                public GalleryType getGalleryViewType() {
                    return params.getGalleryViewType() == 0 ? GalleryType.Grid_Structure : GalleryType.Horizontal_Structure;
                }

                @Override
                public boolean enableFolderStructure() {
                    return params.isEnableFolderStructure();
                }

                @Override
                public boolean galleryToCameraSwitchEnabled() {
                    return params.isGalleryToCameraSwitchEnabled();
                }

                @Override
                public boolean isRestrictedExtensionJpgPngEnabled() {
                    return params.isRestrictedExtensionJpgPngEnabled();
                }

                @Override
                public int getNumberOfPhotos() {
                    return params.getNumberOfPhotos();
                }

                @Override
                public boolean getTagEnabled() {
                    return params.isTagEnabled();
                }

                @Override
                public List<ImageTagModel> getImageTagsModel() {
                    return getImageTagModels(params.getImageTagListJson());
                }

                @Override
                public List<FileInfo> getAlreadyAddedImages() {
                    return getAlreadyAddedImagesList(params.getAlreadyAddedImagesJson());
                }

                @Override
                public boolean enableImageEditing() {
                    return params.isEnableImageEditing();
                }

                @Override
                public CustomParameters getCustomParameters() {
                    CustomParameters.CustomParametersBuilder builder = new CustomParameters.CustomParametersBuilder();
                    builder.setLocationRestrictive(params.isLocationRestrictive());
                    builder.sethideCameraButtonInNeutral(params.isHideCameraButtonInNeutral());
                    builder.setHideGalleryButtonInNeutral(params.isHideGalleryButtonInNeutral());
                    return builder.build();
                }
            }), new OnImageCollectionListener() {
                @Override
                public void imageCollection(NeonResponse neonResponse) {
                    callback.invoke(getImageCollection(neonResponse));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void openNeutral(final String neonReactParamsJson, final Callback callback) {
        try {
            final NeonReactParams params = getNeonReactParams(neonReactParamsJson);
            PhotosLibrary.collectPhotos(params.getRequestCode(), getCurrentActivity(), params.getLibraryMode() == 0 ? LibraryMode.Relax : LibraryMode.Restrict, PhotosMode.setNeutralMode().setParams(
                    new INeutralParam() {
                        @Override
                        public int getNumberOfPhotos() {
                            return params.getNumberOfPhotos();
                        }

                        @Override
                        public boolean getTagEnabled() {
                            return params.isTagEnabled();
                        }

                        @Override
                        public List<ImageTagModel> getImageTagsModel() {
                            return getImageTagModels(params.getImageTagListJson());
                        }

                        @Override
                        public List<FileInfo> getAlreadyAddedImages() {
                            return getAlreadyAddedImagesList(params.getAlreadyAddedImagesJson());
                        }

                        @Override
                        public boolean enableImageEditing() {
                            return params.isEnableImageEditing();
                        }

                        @Override
                        public CustomParameters getCustomParameters() {
                            CustomParameters.CustomParametersBuilder builder = new CustomParameters.CustomParametersBuilder();
                            builder.setLocationRestrictive(params.isLocationRestrictive());
                            builder.sethideCameraButtonInNeutral(params.isHideCameraButtonInNeutral());
                            builder.setHideGalleryButtonInNeutral(params.isHideGalleryButtonInNeutral());
                            return builder.build();
                        }

                        @Override
                        public boolean selectVideos() {
                            return params.isSelectVideos();
                        }

                        @Override
                        public GalleryType getGalleryViewType() {
                            return params.getGalleryViewType() == 0 ? GalleryType.Grid_Structure : GalleryType.Horizontal_Structure;
                        }

                        @Override
                        public boolean enableFolderStructure() {
                            return params.isEnableFolderStructure();
                        }

                        @Override
                        public boolean galleryToCameraSwitchEnabled() {
                            return params.isGalleryToCameraSwitchEnabled();
                        }

                        @Override
                        public boolean isRestrictedExtensionJpgPngEnabled() {
                            return params.isRestrictedExtensionJpgPngEnabled();
                        }

                        @Override
                        public CameraFacing getCameraFacing() {
                            return params.getCameraFacing() == 0 ? CameraFacing.back : CameraFacing.front;
                        }

                        @Override
                        public CameraOrientation getCameraOrientation() {
                            return params.getCameraOrientation() == 0 ? CameraOrientation.landscape : CameraOrientation.portrait;
                        }

                        @Override
                        public boolean getFlashEnabled() {
                            return params.isFlashEnabled();
                        }

                        @Override
                        public boolean getCameraSwitchingEnabled() {
                            return params.isCameraSwitchingEnabled();
                        }

                        @Override
                        public boolean getVideoCaptureEnabled() {
                            return params.isVideoCaptureEnabled();
                        }
                        @Override
                        public boolean hasOnlyProfileTag() {
                            return params.isHasOnlyProfileTag();
                        }

                        @Override
                        public String getProfileTagName() {
                            return params.getProfileTagName();
                        }

                        @Override
                        public CameraType getCameraViewType() {
                            return params.getCameraViewType() == 0 ? CameraType.normal_camera : CameraType.gallery_preview_camera;
                        }

                        @Override
                        public boolean cameraToGallerySwitchEnabled() {
                            return params.isCameraToGallerySwitchEnabled();
                        }
                    }), new OnImageCollectionListener() {
                @Override
                public void imageCollection(NeonResponse neonResponse) {
                    callback.invoke(getImageCollection(neonResponse));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ReactMethod
    private void livePhotos(final String neonReactParamsJson, final Callback callback) {
        try {
            final NeonReactParams params = getNeonReactParams(neonReactParamsJson);
            PhotosLibrary.collectLivePhotos(params.getRequestCode(), params.getLibraryMode() == 0 ? LibraryMode.Relax : LibraryMode.Restrict, getCurrentActivity(), new OnImageCollectionListener() {
                @Override
                public void imageCollection(NeonResponse neonResponse) {

                }
            }, new LivePhotosListener() {
                @Override
                public void onLivePhotoCollected(NeonResponse neonResponse) {
                    callback.invoke(getImageCollection(neonResponse));
                }
            }, new ICameraParam() {
                @Override
                public CameraFacing getCameraFacing() {
                    return params.getCameraFacing() == 0 ? CameraFacing.back : CameraFacing.front;
                }

                @Override
                public CameraOrientation getCameraOrientation() {
                    return params.getCameraOrientation() == 0 ? CameraOrientation.landscape : CameraOrientation.portrait;
                }

                @Override
                public boolean getFlashEnabled() {
                    return params.isFlashEnabled();
                }

                @Override
                public boolean getCameraSwitchingEnabled() {
                    return params.isCameraSwitchingEnabled();
                }

                @Override
                public boolean getVideoCaptureEnabled() {
                    return params.isVideoCaptureEnabled();
                }

                @Override
                public CameraType getCameraViewType() {
                    return params.getCameraViewType() == 0 ? CameraType.normal_camera : CameraType.gallery_preview_camera;
                }

                @Override
                public boolean cameraToGallerySwitchEnabled() {
                    return params.isCameraToGallerySwitchEnabled();
                }

                @Override
                public int getNumberOfPhotos() {
                    return params.getNumberOfPhotos();
                }

                @Override
                public boolean getTagEnabled() {
                    return params.isTagEnabled();
                }

                @Override
                public List<ImageTagModel> getImageTagsModel() {
                    return getImageTagModels(params.getImageTagListJson());
                }

                @Override
                public List<FileInfo> getAlreadyAddedImages() {
                    return getAlreadyAddedImagesList(params.getAlreadyAddedImagesJson());
                }

                @Override
                public boolean enableImageEditing() {
                    return params.isEnableImageEditing();
                }

                @Override
                public CustomParameters getCustomParameters() {
                    CustomParameters.CustomParametersBuilder builder = new CustomParameters.CustomParametersBuilder();
                    builder.setLocationRestrictive(params.isLocationRestrictive());
                    builder.sethideCameraButtonInNeutral(params.isHideCameraButtonInNeutral());
                    builder.setHideGalleryButtonInNeutral(params.isHideGalleryButtonInNeutral());
                    return builder.build();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private List<FileInfo> getAlreadyAddedImagesList(String jsonData) {

        if (jsonData != null && jsonData != "") {
            List<FileInfo> alreadyAddedImages = new ArrayList<>();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<List<FileInfo>>() {
            }.getType();
            alreadyAddedImages = gson.fromJson(jsonData, type);
            return alreadyAddedImages;
        } else {
            return null;
        }
    }

    private List<ImageTagModel> getImageTagModels(String jsonData) {

        if (jsonData != null && jsonData != "") {
            List<ImageTagModel> tagModels = new ArrayList<>();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<List<ImageTagModel>>() {
            }.getType();
            tagModels = gson.fromJson(jsonData, type);
            return tagModels;
        } else {
            return null;
        }
    }

    private NeonReactParams getNeonReactParams(String jsonData) {
        if (jsonData != null && jsonData != "") {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            NeonReactParams neonReactParams = gson.fromJson(jsonData, NeonReactParams.class);
            return neonReactParams;
        } else {
            return new NeonReactParams();
        }
    }

    private String getImageCollection(NeonResponse neonResponse) {
        List<FileInfo> imageCollection = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (neonResponse.getImageCollection() != null) {
             imageCollection = neonResponse.getImageCollection();
        }
        return gson.toJson(imageCollection);

    }
}

