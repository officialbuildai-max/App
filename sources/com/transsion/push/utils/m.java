package com.transsion.push.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.transsion.http.impl.BitmapCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class m {

    /* loaded from: classes6.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f50992a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f50993b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f50994c;

        a(HashMap hashMap, AtomicInteger atomicInteger, d dVar) {
            this.f50992a = hashMap;
            this.f50993b = atomicInteger;
            this.f50994c = dVar;
        }

        @Override // com.transsion.push.utils.m.c
        public void a(String str, Bitmap bitmap) {
            this.f50992a.put(str, bitmap);
            if (this.f50993b.decrementAndGet() == 0) {
                this.f50994c.a(this.f50992a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends BitmapCallback {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f50995e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f50996f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f50997g;

        b(String str, c cVar, int i11) {
            this.f50995e = str;
            this.f50996f = cVar;
            this.f50997g = i11;
        }

        @Override // com.transsion.http.impl.BitmapCallback
        public void y(int i11, Bitmap bitmap, Throwable th2) {
            PushLogUtils.LOG.i("image download fail, url:" + this.f50995e);
            c cVar = this.f50996f;
            if (cVar != null) {
                cVar.a(this.f50995e, null);
            }
        }

        @Override // com.transsion.http.impl.BitmapCallback
        public void z(int i11, Bitmap bitmap) {
            PushLogUtils.LOG.g("image download complete, url:" + this.f50995e);
            c cVar = this.f50996f;
            if (cVar != null) {
                if (this.f50997g != 3) {
                    cVar.a(this.f50995e, bitmap);
                    return;
                }
                try {
                    this.f50996f.a(this.f50995e, com.transsion.push.utils.a.a(qk.a.a(), bitmap));
                } catch (Exception unused) {
                    this.f50996f.a(this.f50995e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface c {
        void a(String str, Bitmap bitmap);
    }

    /* loaded from: classes6.dex */
    interface d {
        void a(HashMap hashMap);
    }

    private static void a(int i11, String str, c cVar) {
        try {
            ((yl.a) ((yl.a) ((yl.a) ((yl.a) wl.a.a(qk.a.a()).f(true).b(qk.a.c())).a(10000)).c(10000)).d(str)).e().a(new b(str, cVar, i11));
        } catch (Exception unused) {
            if (cVar != null) {
                cVar.a(str, null);
            }
        }
    }

    public static void b(int i11, List list, d dVar) {
        HashMap hashMap = new HashMap();
        AtomicInteger atomicInteger = new AtomicInteger(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                a(i11, str, new a(hashMap, atomicInteger, dVar));
            }
        }
    }
}
