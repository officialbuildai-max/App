package com.github.mmin18.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* loaded from: classes3.dex */
public class e implements c {

    /* renamed from: e, reason: collision with root package name */
    static Boolean f24223e;

    /* renamed from: a, reason: collision with root package name */
    private RenderScript f24224a;

    /* renamed from: b, reason: collision with root package name */
    private ScriptIntrinsicBlur f24225b;

    /* renamed from: c, reason: collision with root package name */
    private Allocation f24226c;

    /* renamed from: d, reason: collision with root package name */
    private Allocation f24227d;

    static boolean c(Context context) {
        if (f24223e == null && context != null) {
            f24223e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return f24223e == Boolean.TRUE;
    }

    @Override // com.github.mmin18.widget.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.f24226c.copyFrom(bitmap);
        this.f24225b.setInput(this.f24226c);
        this.f24225b.forEach(this.f24227d);
        this.f24227d.copyTo(bitmap2);
    }

    @Override // com.github.mmin18.widget.c
    public boolean b(Context context, Bitmap bitmap, float f11) {
        if (this.f24224a == null) {
            try {
                RenderScript create = RenderScript.create(context);
                this.f24224a = create;
                this.f24225b = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            } catch (RSRuntimeException e11) {
                if (c(context)) {
                    throw e11;
                }
                release();
                return false;
            }
        }
        this.f24225b.setRadius(f11);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f24224a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f24226c = createFromBitmap;
        this.f24227d = Allocation.createTyped(this.f24224a, createFromBitmap.getType());
        return true;
    }

    @Override // com.github.mmin18.widget.c
    public void release() {
        Allocation allocation = this.f24226c;
        if (allocation != null) {
            allocation.destroy();
            this.f24226c = null;
        }
        Allocation allocation2 = this.f24227d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f24227d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f24225b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f24225b = null;
        }
        RenderScript renderScript = this.f24224a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f24224a = null;
        }
    }
}
