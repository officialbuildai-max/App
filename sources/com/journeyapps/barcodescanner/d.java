package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.iid.InstanceID;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.client.android.R$string;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.d;
import gd.e;
import gd.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: o, reason: collision with root package name */
    private static final String f34061o = "d";

    /* renamed from: p, reason: collision with root package name */
    private static int f34062p = 250;

    /* renamed from: a, reason: collision with root package name */
    private Activity f34063a;

    /* renamed from: b, reason: collision with root package name */
    private DecoratedBarcodeView f34064b;

    /* renamed from: h, reason: collision with root package name */
    private h f34070h;

    /* renamed from: i, reason: collision with root package name */
    private e f34071i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f34072j;

    /* renamed from: m, reason: collision with root package name */
    private final CameraPreview.f f34075m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f34076n;

    /* renamed from: c, reason: collision with root package name */
    private int f34065c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34066d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34067e = true;

    /* renamed from: f, reason: collision with root package name */
    private String f34068f = "";

    /* renamed from: g, reason: collision with root package name */
    private boolean f34069g = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34073k = false;

    /* renamed from: l, reason: collision with root package name */
    private xe.a f34074l = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements xe.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(xe.c cVar) {
            d.this.B(cVar);
        }

        @Override // xe.a
        public void a(List list) {
        }

        @Override // xe.a
        public void b(final xe.c cVar) {
            d.this.f34064b.pause();
            d.this.f34071i.f();
            d.this.f34072j.post(new Runnable() { // from class: com.journeyapps.barcodescanner.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.this.d(cVar);
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    class b implements CameraPreview.f {
        b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b() {
            if (d.this.f34073k) {
                String unused = d.f34061o;
                d.this.s();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c(Exception exc) {
            d dVar = d.this;
            dVar.m(dVar.f34063a.getString(R$string.zxing_msg_camera_framework_bug));
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public d(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.f34075m = bVar;
        this.f34076n = false;
        this.f34063a = activity;
        this.f34064b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().addStateListener(bVar);
        this.f34072j = new Handler();
        this.f34070h = new h(activity, new Runnable() { // from class: xe.d
            @Override // java.lang.Runnable
            public final void run() {
                com.journeyapps.barcodescanner.d.this.s();
            }
        });
        this.f34071i = new e(activity);
    }

    public static Intent A(xe.c cVar, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", cVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", cVar.a().toString());
        byte[] c11 = cVar.c();
        if (c11 != null && c11.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", c11);
        }
        Map d11 = cVar.d();
        if (d11 != null) {
            ResultMetadataType resultMetadataType = ResultMetadataType.UPC_EAN_EXTENSION;
            if (d11.containsKey(resultMetadataType)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", d11.get(resultMetadataType).toString());
            }
            Number number = (Number) d11.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) d11.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable iterable = (Iterable) d11.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i11, (byte[]) it.next());
                    i11++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    private void D() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("MISSING_CAMERA_PERMISSION", true);
        this.f34063a.setResult(0, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void s() {
        this.f34063a.finish();
    }

    private String o(xe.c cVar) {
        if (this.f34066d) {
            Bitmap b11 = cVar.b();
            try {
                File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.f34063a.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                b11.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return createTempFile.getAbsolutePath();
            } catch (IOException e11) {
                Log.w(f34061o, "Unable to create temporary file and store bitmap! " + e11);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(DialogInterface dialogInterface, int i11) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(DialogInterface dialogInterface) {
        s();
    }

    private void z() {
        if (androidx.core.content.b.checkSelfPermission(this.f34063a, "android.permission.CAMERA") == 0) {
            this.f34064b.resume();
        } else {
            if (this.f34076n) {
                return;
            }
            ActivityCompat.g(this.f34063a, new String[]{"android.permission.CAMERA"}, f34062p);
            this.f34076n = true;
        }
    }

    protected void B(xe.c cVar) {
        this.f34063a.setResult(-1, A(cVar, o(cVar)));
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra(InstanceID.ERROR_TIMEOUT, true);
        this.f34063a.setResult(0, intent);
        k();
    }

    public void E(boolean z10, String str) {
        this.f34067e = z10;
        if (str == null) {
            str = "";
        }
        this.f34068f = str;
    }

    protected void k() {
        if (this.f34064b.getBarcodeView().isCameraClosed()) {
            s();
        } else {
            this.f34073k = true;
        }
        this.f34064b.pause();
        this.f34070h.d();
    }

    public void l() {
        this.f34064b.decodeSingle(this.f34074l);
    }

    protected void m(String str) {
        if (this.f34063a.isFinishing() || this.f34069g || this.f34073k) {
            return;
        }
        if (str.isEmpty()) {
            str = this.f34063a.getString(R$string.zxing_msg_camera_framework_bug);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f34063a);
        builder.setTitle(this.f34063a.getString(R$string.zxing_app_name));
        builder.setMessage(str);
        builder.setPositiveButton(R$string.zxing_button_ok, new DialogInterface.OnClickListener() { // from class: xe.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                com.journeyapps.barcodescanner.d.this.q(dialogInterface, i11);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xe.f
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.journeyapps.barcodescanner.d.this.r(dialogInterface);
            }
        });
        builder.show();
    }

    public void p(Intent intent, Bundle bundle) {
        this.f34063a.getWindow().addFlags(128);
        if (bundle != null) {
            this.f34065c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                t();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f34064b.initializeFromIntent(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.f34071i.g(false);
            }
            if (intent.hasExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG")) {
                E(intent.getBooleanExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG", true), intent.getStringExtra("MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE"));
            }
            if (intent.hasExtra(InstanceID.ERROR_TIMEOUT)) {
                this.f34072j.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.C();
                    }
                }, intent.getLongExtra(InstanceID.ERROR_TIMEOUT, 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.f34066d = true;
            }
        }
    }

    protected void t() {
        if (this.f34065c == -1) {
            int rotation = this.f34063a.getWindowManager().getDefaultDisplay().getRotation();
            int i11 = this.f34063a.getResources().getConfiguration().orientation;
            int i12 = 0;
            if (i11 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i12 = 8;
                }
            } else if (i11 == 1) {
                i12 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f34065c = i12;
        }
        this.f34063a.setRequestedOrientation(this.f34065c);
    }

    public void u() {
        this.f34069g = true;
        this.f34070h.d();
        this.f34072j.removeCallbacksAndMessages(null);
    }

    public void v() {
        this.f34070h.d();
        this.f34064b.pauseAndWait();
    }

    public void w(int i11, String[] strArr, int[] iArr) {
        if (i11 == f34062p) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f34064b.resume();
                return;
            }
            D();
            if (this.f34067e) {
                m(this.f34068f);
            } else {
                k();
            }
        }
    }

    public void x() {
        z();
        this.f34070h.h();
    }

    public void y(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f34065c);
    }
}
