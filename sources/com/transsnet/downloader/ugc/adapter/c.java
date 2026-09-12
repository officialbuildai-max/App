package com.transsnet.downloader.ugc.adapter;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class c {

    /* loaded from: classes7.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final DownloadBean f59737a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DownloadBean bean) {
            super(null);
            Intrinsics.h(bean, "bean");
            this.f59737a = bean;
        }

        public final DownloadBean a() {
            return this.f59737a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.c(this.f59737a, ((a) obj).f59737a);
        }

        public int hashCode() {
            return this.f59737a.hashCode();
        }

        public String toString() {
            return "AllEpBtnItem(bean=" + this.f59737a + ")";
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private final DownloadBean f59738a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DownloadBean bean) {
            super(null);
            Intrinsics.h(bean, "bean");
            this.f59738a = bean;
        }

        public final b a(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            return new b(bean);
        }

        public final DownloadBean b() {
            return this.f59738a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.c(this.f59738a, ((b) obj).f59738a);
        }

        public int hashCode() {
            return this.f59738a.hashCode();
        }

        public String toString() {
            return "DownloadedItem(bean=" + this.f59738a + ")";
        }
    }

    /* renamed from: com.transsnet.downloader.ugc.adapter.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0717c extends c {

        /* renamed from: a, reason: collision with root package name */
        private final DownloadBean f59739a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0717c(DownloadBean bean) {
            super(null);
            Intrinsics.h(bean, "bean");
            this.f59739a = bean;
        }

        public final C0717c a(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            return new C0717c(bean);
        }

        public final DownloadBean b() {
            return this.f59739a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0717c) && Intrinsics.c(this.f59739a, ((C0717c) obj).f59739a);
        }

        public int hashCode() {
            return this.f59739a.hashCode();
        }

        public String toString() {
            return "DownloadingItem(bean=" + this.f59739a + ")";
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends c {

        /* renamed from: a, reason: collision with root package name */
        public static final d f59740a = new d();

        private d() {
            super(null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends c {

        /* renamed from: a, reason: collision with root package name */
        private final UGCVideo f59741a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UGCVideo video) {
            super(null);
            Intrinsics.h(video, "video");
            this.f59741a = video;
        }

        public final UGCVideo a() {
            return this.f59741a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.c(this.f59741a, ((e) obj).f59741a);
        }

        public int hashCode() {
            return this.f59741a.hashCode();
        }

        public String toString() {
            return "ForYouItem(video=" + this.f59741a + ")";
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends c {

        /* renamed from: a, reason: collision with root package name */
        public static final f f59742a = new f();

        private f() {
            super(null);
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
