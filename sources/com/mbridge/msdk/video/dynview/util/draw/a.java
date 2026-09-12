package com.mbridge.msdk.video.dynview.util.draw;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.shape.a;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f39158d;

    /* renamed from: a, reason: collision with root package name */
    private View f39159a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f39160b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f39161c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.video.dynview.util.draw.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0564a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f39162a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f39163b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f39164c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f39165d;

        /* renamed from: com.mbridge.msdk.video.dynview.util.draw.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0565a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a.b f39167a;

            RunnableC0565a(a.b bVar) {
                this.f39167a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f39159a == null || this.f39167a.a() == null) {
                    return;
                }
                a.this.f39159a.setBackground(this.f39167a.a());
            }
        }

        RunnableC0564a(Bitmap bitmap, int i11, float f11, float f12) {
            this.f39162a = bitmap;
            this.f39163b = i11;
            this.f39164c = f11;
            this.f39165d = f12;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap a11 = y.a(this.f39162a, 10);
                Bitmap a12 = y.a(this.f39162a, 10);
                a.b a13 = com.mbridge.msdk.video.dynview.shape.a.a();
                a13.a(this.f39163b).b(a11).a(a12);
                if (this.f39163b == 2) {
                    float f11 = this.f39164c;
                    float f12 = this.f39165d;
                    if (f11 > f12) {
                        a13.b(f11).a(this.f39165d);
                    } else {
                        a13.b(f12).a(this.f39164c);
                    }
                } else {
                    a13.b(this.f39164c).a(this.f39165d);
                }
                if (a.this.f39159a != null) {
                    a.this.f39159a.post(new RunnableC0565a(a13));
                }
            } catch (Exception e11) {
                o0.b("ChoiceOneDrawBitBg", e11.getMessage());
            }
        }
    }

    private a() {
    }

    public static a a() {
        a aVar;
        if (f39158d != null) {
            return f39158d;
        }
        synchronized (a.class) {
            try {
                if (f39158d == null) {
                    f39158d = new a();
                }
                aVar = f39158d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private synchronized void a(int i11, float f11, float f12, Bitmap bitmap, Bitmap bitmap2) {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new RunnableC0564a(bitmap, i11, f11, f12));
        } catch (Exception e11) {
            o0.a("ChoiceOneDrawBitBg", e11.getMessage());
        }
    }

    public void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view == null || cVar == null || map == null || map.size() == 0 || map.size() < 2 || cVar.b() == null || cVar.b().size() < 2) {
            return;
        }
        this.f39159a = view;
        int h11 = cVar.h();
        float m11 = cVar.m();
        float k11 = cVar.k();
        try {
            List<CampaignEx> b11 = cVar.b();
            String md5 = b11.get(0) != null ? SameMD5.getMD5(b11.get(0).getImageUrl()) : "";
            String md52 = b11.get(1) != null ? SameMD5.getMD5(b11.get(1).getImageUrl()) : "";
            Bitmap bitmap = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
            Bitmap bitmap2 = (TextUtils.isEmpty(md52) || !map.containsKey(md52)) ? null : map.get(md52);
            if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            a(h11, m11, k11, bitmap, bitmap2);
        } catch (Exception e11) {
            o0.b("ChoiceOneDrawBitBg", e11.getMessage());
        }
    }

    public void b() {
        if (this.f39159a != null) {
            this.f39159a = null;
        }
        Bitmap bitmap = this.f39160b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f39160b.recycle();
            this.f39160b = null;
        }
        Bitmap bitmap2 = this.f39161c;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f39161c.recycle();
        this.f39161c = null;
    }
}
