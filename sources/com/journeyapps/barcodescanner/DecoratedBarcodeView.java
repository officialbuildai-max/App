package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$layout;
import com.google.zxing.client.android.R$styleable;
import com.google.zxing.k;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.i;
import gd.f;
import gd.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xe.h;

/* loaded from: classes4.dex */
public class DecoratedBarcodeView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private BarcodeView f33965a;

    /* renamed from: b, reason: collision with root package name */
    private ViewfinderView f33966b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f33967c;

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements xe.a {

        /* renamed from: a, reason: collision with root package name */
        private xe.a f33968a;

        public b(xe.a aVar) {
            this.f33968a = aVar;
        }

        @Override // xe.a
        public void a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.f33966b.addPossibleResultPoint((k) it.next());
            }
            this.f33968a.a(list);
        }

        @Override // xe.a
        public void b(xe.c cVar) {
            this.f33968a.b(cVar);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        b();
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
    }

    private void b() {
        c(null);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_view);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.zxing_view_zxing_scanner_layout, R$layout.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R$id.zxing_barcode_surface);
        this.f33965a = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.p(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R$id.zxing_viewfinder_view);
        this.f33966b = viewfinderView;
        if (viewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        viewfinderView.setCameraPreview(this.f33965a);
        this.f33967c = (TextView) findViewById(R$id.zxing_status_view);
    }

    public void changeCameraParameters(i iVar) {
        this.f33965a.changeCameraParameters(iVar);
    }

    public void decodeContinuous(xe.a aVar) {
        this.f33965a.decodeContinuous(new b(aVar));
    }

    public void decodeSingle(xe.a aVar) {
        this.f33965a.decodeSingle(new b(aVar));
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R$id.zxing_barcode_surface);
    }

    public CameraSettings getCameraSettings() {
        return this.f33965a.getCameraSettings();
    }

    public h getDecoderFactory() {
        return this.f33965a.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.f33967c;
    }

    public ViewfinderView getViewFinder() {
        return this.f33966b;
    }

    public void initializeFromIntent(Intent intent) {
        int intExtra;
        Set a11 = f.a(intent);
        Map a12 = g.a(intent);
        CameraSettings cameraSettings = new CameraSettings();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            cameraSettings.i(intExtra);
        }
        if (intent.hasExtra("TORCH_ENABLED") && intent.getBooleanExtra("TORCH_ENABLED", false)) {
            setTorchOn();
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new com.google.zxing.f().e(a12);
        this.f33965a.setCameraSettings(cameraSettings);
        this.f33965a.setDecoderFactory(new xe.k(a11, a12, stringExtra2, intExtra2));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 24) {
            setTorchOn();
            return true;
        }
        if (i11 == 25) {
            setTorchOff();
            return true;
        }
        if (i11 == 27 || i11 == 80) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void pause() {
        this.f33965a.pause();
    }

    public void pauseAndWait() {
        this.f33965a.pauseAndWait();
    }

    public void resume() {
        this.f33965a.resume();
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f33965a.setCameraSettings(cameraSettings);
    }

    public void setDecoderFactory(h hVar) {
        this.f33965a.setDecoderFactory(hVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.f33967c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
    }

    public void setTorchOff() {
        this.f33965a.setTorch(false);
    }

    public void setTorchOn() {
        this.f33965a.setTorch(true);
    }
}
