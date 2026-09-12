package com.github.mmin18.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: e, reason: collision with root package name */
    static Boolean f24218e;

    /* renamed from: a, reason: collision with root package name */
    private RenderScript f24219a;

    /* renamed from: b, reason: collision with root package name */
    private ScriptIntrinsicBlur f24220b;

    /* renamed from: c, reason: collision with root package name */
    private Allocation f24221c;

    /* renamed from: d, reason: collision with root package name */
    private Allocation f24222d;

    static boolean c(Context context) {
        if (f24218e == null && context != null) {
            f24218e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return f24218e == Boolean.TRUE;
    }

    @Override // com.github.mmin18.widget.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.f24221c.copyFrom(bitmap);
        this.f24220b.setInput(this.f24221c);
        this.f24220b.forEach(this.f24222d);
        this.f24222d.copyTo(bitmap2);
    }

    @Override // com.github.mmin18.widget.c
    public boolean b(Context context, Bitmap bitmap, float f11) {
        if (this.f24219a == null) {
            try {
                RenderScript create = RenderScript.create(context);
                this.f24219a = create;
                this.f24220b = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            } catch (RSRuntimeException e11) {
                if (c(context)) {
                    throw e11;
                }
                release();
                return false;
            }
        }
        this.f24220b.setRadius(f11);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f24219a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f24221c = createFromBitmap;
        this.f24222d = Allocation.createTyped(this.f24219a, createFromBitmap.getType());
        return true;
    }

    @Override // com.github.mmin18.widget.c
    public void release() {
        Allocation allocation = this.f24221c;
        if (allocation != null) {
            allocation.destroy();
            this.f24221c = null;
        }
        Allocation allocation2 = this.f24222d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f24222d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f24220b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f24220b = null;
        }
        RenderScript renderScript = this.f24219a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f24219a = null;
        }
    }
}
