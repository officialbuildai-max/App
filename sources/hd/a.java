package hd;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f64546a = "hd.a";

    public static int a(int i11) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f64546a, "No cameras!");
            return -1;
        }
        boolean z10 = i11 >= 0;
        if (!z10) {
            i11 = 0;
            while (i11 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i11, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i11++;
            }
        }
        return i11 < numberOfCameras ? i11 : z10 ? -1 : 0;
    }

    public static Camera b(int i11) {
        int a11 = a(i11);
        if (a11 == -1) {
            return null;
        }
        return Camera.open(a11);
    }
}
