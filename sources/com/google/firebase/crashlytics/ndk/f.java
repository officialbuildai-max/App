package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes4.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    public final c f31843a;

    /* renamed from: b, reason: collision with root package name */
    public final File f31844b;

    /* renamed from: c, reason: collision with root package name */
    public final File f31845c;

    /* renamed from: d, reason: collision with root package name */
    public final File f31846d;

    /* renamed from: e, reason: collision with root package name */
    public final File f31847e;

    /* renamed from: f, reason: collision with root package name */
    public final File f31848f;

    /* renamed from: g, reason: collision with root package name */
    public final File f31849g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private c f31850a;

        /* renamed from: b, reason: collision with root package name */
        private File f31851b;

        /* renamed from: c, reason: collision with root package name */
        private File f31852c;

        /* renamed from: d, reason: collision with root package name */
        private File f31853d;

        /* renamed from: e, reason: collision with root package name */
        private File f31854e;

        /* renamed from: f, reason: collision with root package name */
        private File f31855f;

        /* renamed from: g, reason: collision with root package name */
        private File f31856g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b h(File file) {
            this.f31854e = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f i() {
            return new f(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b j(File file) {
            this.f31855f = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b k(File file) {
            this.f31852c = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b l(c cVar) {
            this.f31850a = cVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b m(File file) {
            this.f31856g = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b n(File file) {
            this.f31853d = file;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final File f31857a;

        /* renamed from: b, reason: collision with root package name */
        public final CrashlyticsReport.a f31858b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(File file, CrashlyticsReport.a aVar) {
            this.f31857a = file;
            this.f31858b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            File file = this.f31857a;
            return (file != null && file.exists()) || this.f31858b != null;
        }
    }

    private f(b bVar) {
        this.f31843a = bVar.f31850a;
        this.f31844b = bVar.f31851b;
        this.f31845c = bVar.f31852c;
        this.f31846d = bVar.f31853d;
        this.f31847e = bVar.f31854e;
        this.f31848f = bVar.f31855f;
        this.f31849g = bVar.f31856g;
    }
}
