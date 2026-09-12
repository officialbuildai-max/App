package com.amazonaws.services.s3;

/* loaded from: classes2.dex */
public class S3ClientOptions {

    /* renamed from: a, reason: collision with root package name */
    private boolean f18679a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f18680b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f18681c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f18682d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f18683e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f18684f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f18685a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f18686b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f18687c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f18688d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f18689e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f18690f;

        private Builder() {
            this.f18685a = false;
            this.f18686b = false;
            this.f18687c = false;
            this.f18688d = false;
            this.f18689e = false;
            this.f18690f = false;
        }

        public S3ClientOptions a() {
            return new S3ClientOptions(this.f18685a, this.f18686b, this.f18687c, this.f18688d, this.f18689e, this.f18690f);
        }

        public Builder b(boolean z10) {
            this.f18688d = z10;
            return this;
        }

        public Builder c(boolean z10) {
            this.f18686b = z10;
            return this;
        }
    }

    @Deprecated
    public S3ClientOptions() {
        this.f18679a = false;
        this.f18680b = false;
        this.f18681c = false;
        this.f18682d = false;
        this.f18683e = false;
        this.f18684f = false;
    }

    public S3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.f18679a = s3ClientOptions.f18679a;
        this.f18680b = s3ClientOptions.f18680b;
        this.f18681c = s3ClientOptions.f18681c;
        this.f18682d = s3ClientOptions.f18682d;
        this.f18683e = s3ClientOptions.f18683e;
        this.f18684f = s3ClientOptions.f18684f;
    }

    private S3ClientOptions(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f18679a = z10;
        this.f18680b = z11;
        this.f18681c = z12;
        this.f18682d = z13;
        this.f18683e = z14;
        this.f18684f = z15;
    }

    public static Builder a() {
        return new Builder();
    }

    public boolean b() {
        return this.f18682d;
    }

    public boolean c() {
        return this.f18679a;
    }

    public boolean d() {
        return this.f18684f;
    }

    public boolean e() {
        return this.f18680b;
    }
}
