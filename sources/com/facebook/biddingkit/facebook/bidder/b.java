package com.facebook.biddingkit.facebook.bidder;

import com.facebook.biddingkit.gen.FBAdBidAuctionType;
import com.facebook.biddingkit.gen.FacebookAdBidFormat;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f24157a = "FACEBOOK_BIDDER";

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f24158a;

        /* renamed from: b, reason: collision with root package name */
        private String f24159b;

        /* renamed from: c, reason: collision with root package name */
        private FacebookAdBidFormat f24160c;

        /* renamed from: d, reason: collision with root package name */
        private String f24161d;

        /* renamed from: e, reason: collision with root package name */
        private String f24162e;

        /* renamed from: f, reason: collision with root package name */
        private FBAdBidAuctionType f24163f = FBAdBidAuctionType.FIRST_PRICE;

        /* renamed from: g, reason: collision with root package name */
        private String f24164g;

        public a(String str, String str2, FacebookAdBidFormat facebookAdBidFormat, String str3) {
            this.f24158a = str;
            this.f24159b = str2;
            this.f24160c = facebookAdBidFormat;
            this.f24162e = str3;
            this.f24164g = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String a() {
            return this.f24158a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String b() {
            return this.f24161d;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String c() {
            return this.f24159b;
        }

        public a d(String str) {
            this.f24161d = str;
            return this;
        }
    }

    public static j8.b a(String str) {
        return new FacebookNotifier(str, new c(com.facebook.biddingkit.bridge.a.b()));
    }
}
