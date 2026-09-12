package com.transsnet.downloader.manager;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final a f59623a = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ g b(a aVar, Context context, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                context = null;
            }
            return aVar.a(context);
        }

        public final g a(Context context) {
            return DownloadManagerImpl.f59556y.a();
        }
    }
}
