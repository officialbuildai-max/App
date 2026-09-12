package com.hisavana.mediation.ad;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class ViewBinder {
    public final List<Integer> actionIds;
    public View actionView;
    public final int adBadgeView;
    public final int adChoicesView;
    public final int adCloseView;
    public final int adDisclaimerView;
    public final int adStoreMarkView;
    public final int callToActionId;
    public final int descriptionId;
    public final int domainId;
    public final int downloadsId;
    public final int feedbackId;
    public Drawable iconDrawable;
    public final int iconId;
    public View layout;
    public final int layoutId;
    public final int likesId;
    public final int mediaId;
    public final int mode;
    public final int priceId;
    public final int ratingId;
    public final int sourceSizeId;
    public final int sponsoredId;
    public final int titleId;

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f33241a;
        public View actionView;

        /* renamed from: b, reason: collision with root package name */
        public int f33242b;

        /* renamed from: c, reason: collision with root package name */
        public int f33243c;

        /* renamed from: d, reason: collision with root package name */
        public int f33244d;

        /* renamed from: e, reason: collision with root package name */
        public int f33245e;

        /* renamed from: f, reason: collision with root package name */
        public int f33246f;

        /* renamed from: g, reason: collision with root package name */
        public int f33247g;

        /* renamed from: h, reason: collision with root package name */
        public int f33248h;

        /* renamed from: i, reason: collision with root package name */
        public int f33249i;
        public Drawable iconDrawable;

        /* renamed from: j, reason: collision with root package name */
        public int f33250j;

        /* renamed from: k, reason: collision with root package name */
        public int f33251k;

        /* renamed from: l, reason: collision with root package name */
        public int f33252l;

        /* renamed from: m, reason: collision with root package name */
        public int f33253m;

        /* renamed from: n, reason: collision with root package name */
        public int f33254n;

        /* renamed from: o, reason: collision with root package name */
        public int f33255o;

        /* renamed from: p, reason: collision with root package name */
        public List<Integer> f33256p;

        /* renamed from: q, reason: collision with root package name */
        public View f33257q;

        /* renamed from: r, reason: collision with root package name */
        public int f33258r;

        /* renamed from: s, reason: collision with root package name */
        public int f33259s;

        /* renamed from: t, reason: collision with root package name */
        public int f33260t;

        /* renamed from: u, reason: collision with root package name */
        public int f33261u;

        /* renamed from: v, reason: collision with root package name */
        public int f33262v;

        public Builder(int i11) {
            this.f33241a = i11;
        }

        public Builder(@NonNull View view) {
            this.f33257q = view;
        }

        @NonNull
        public final Builder actionIds(Integer... numArr) {
            this.f33256p = Arrays.asList(numArr);
            return this;
        }

        public final Builder adBadgeView(int i11) {
            this.f33253m = i11;
            return this;
        }

        @NonNull
        public final Builder adChoicesView(int i11) {
            this.f33254n = i11;
            return this;
        }

        public final Builder adCloseView(int i11) {
            this.f33255o = i11;
            return this;
        }

        public final Builder adDisclaimerView(int i11) {
            this.f33252l = i11;
            return this;
        }

        @NonNull
        public final ViewBinder build() {
            return new ViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i11) {
            this.f33244d = i11;
            return this;
        }

        public final Builder contextMode(int i11) {
            this.f33258r = i11;
            return this;
        }

        @NonNull
        public final Builder descriptionId(int i11) {
            this.f33246f = i11;
            return this;
        }

        public final Builder domainView(int i11) {
            this.f33260t = i11;
            return this;
        }

        @NonNull
        public final Builder downloadsId(int i11) {
            this.f33251k = i11;
            return this;
        }

        public final Builder feedbackView(int i11) {
            this.f33261u = i11;
            return this;
        }

        public final Builder iconDrawable(Drawable drawable) {
            this.iconDrawable = drawable;
            return this;
        }

        @NonNull
        public final Builder iconId(int i11) {
            this.f33243c = i11;
            return this;
        }

        @NonNull
        public final Builder likesId(int i11) {
            this.f33249i = i11;
            return this;
        }

        @NonNull
        public final Builder mediaId(int i11) {
            this.f33245e = i11;
            return this;
        }

        @NonNull
        public final Builder priceId(int i11) {
            this.f33250j = i11;
            return this;
        }

        @NonNull
        public final Builder ratingId(int i11) {
            this.f33248h = i11;
            return this;
        }

        public Builder setActionView(View view) {
            this.actionView = view;
            return this;
        }

        @NonNull
        public final Builder sourceSizeId(int i11) {
            this.f33262v = i11;
            return this;
        }

        @NonNull
        public final Builder sponsoredId(int i11) {
            this.f33247g = i11;
            return this;
        }

        public final Builder storeMarkView(int i11) {
            this.f33259s = i11;
            return this;
        }

        @NonNull
        public final Builder titleId(int i11) {
            this.f33242b = i11;
            return this;
        }
    }

    public ViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.f33241a;
        this.layout = builder.f33257q;
        this.titleId = builder.f33242b;
        this.callToActionId = builder.f33244d;
        this.iconId = builder.f33243c;
        this.mediaId = builder.f33245e;
        this.descriptionId = builder.f33246f;
        this.sponsoredId = builder.f33247g;
        this.ratingId = builder.f33248h;
        this.likesId = builder.f33249i;
        this.priceId = builder.f33250j;
        this.downloadsId = builder.f33251k;
        this.actionIds = builder.f33256p;
        this.mode = builder.f33258r;
        this.adDisclaimerView = builder.f33252l;
        this.adBadgeView = builder.f33253m;
        this.adChoicesView = builder.f33254n;
        this.adCloseView = builder.f33255o;
        this.adStoreMarkView = builder.f33259s;
        this.domainId = builder.f33260t;
        this.feedbackId = builder.f33261u;
        this.iconDrawable = builder.iconDrawable;
        this.actionView = builder.actionView;
        this.sourceSizeId = builder.f33262v;
    }
}
