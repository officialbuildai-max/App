package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$layout;

/* loaded from: classes4.dex */
public class CaptureActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private d f33963a;

    /* renamed from: b, reason: collision with root package name */
    private DecoratedBarcodeView f33964b;

    protected DecoratedBarcodeView a() {
        setContentView(R$layout.zxing_capture);
        return (DecoratedBarcodeView) findViewById(R$id.zxing_barcode_scanner);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f33964b = a();
        d dVar = new d(this, this.f33964b);
        this.f33963a = dVar;
        dVar.p(getIntent(), bundle);
        this.f33963a.l();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f33963a.u();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        return this.f33964b.onKeyDown(i11, keyEvent) || super.onKeyDown(i11, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f33963a.v();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        this.f33963a.w(i11, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f33963a.x();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f33963a.y(bundle);
    }
}
