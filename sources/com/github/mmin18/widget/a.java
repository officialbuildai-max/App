package com.github.mmin18.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: e, reason: collision with root package name */
    static Boolean f24213e;

    /* renamed from: a, reason: collision with root package name */
    private RenderScript f24214a;

    /* renamed from: b, reason: collision with root package name */
    private ScriptIntrinsicBlur f24215b;

    /* renamed from: c, reason: collision with root package name */
    private Allocation f24216c;

    /* renamed from: d, reason: collision with root package name */
    private Allocation f24217d;

    static boolean c(Context context) {
        if (f24213e == null && context != null) {
            f24213e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return f24213e == Boolean.TRUE;
    }

    @Override // com.github.mmin18.widget.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.f24216c.copyFrom(bitmap);
        this.f24215b.setInput(this.f24216c);
        this.f24215b.forEach(this.f24217d);
        this.f24217d.copyTo(bitmap2);
    }

    @Override // com.github.mmin18.widget.c
    public boolean b(Context context, Bitmap bitmap, float f11) {
        if (this.f24214a == null) {
            try {
                RenderScript create = RenderScript.create(context);
                this.f24214a = create;
                this.f24215b = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            } catch (RSRuntimeException e11) {
                if (c(context)) {
                    throw e11;
                }
                release();
                return false;
            }
        }
        this.f24215b.setRadius(f11);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f24214a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f24216c = createFromBitmap;
        this.f24217d = Allocation.createTyped(this.f24214a, createFromBitmap.getType());
        return true;
    }

    @Override // com.github.mmin18.widget.c
    public void release() {
        Allocation allocation = this.f24216c;
        if (allocation != null) {
            allocation.destroy();
            this.f24216c = null;
        }
        Allocation allocation2 = this.f24217d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f24217d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f24215b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f24215b = null;
        }
        RenderScript renderScript = this.f24214a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f24214a = null;
        }
    }
}
