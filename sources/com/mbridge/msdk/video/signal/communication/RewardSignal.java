package com.mbridge.msdk.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.t0;

/* loaded from: classes5.dex */
public class RewardSignal extends BaseRewardSignal implements BaseIRewardCommunication {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f39556i = 0;

    /* renamed from: h, reason: collision with root package name */
    private Handler f39557h = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39559b;

        a(Object obj, String str) {
            this.f39558a = obj;
            this.f39559b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.getEndScreenInfo(this.f39558a, this.f39559b);
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39562b;

        b(Object obj, String str) {
            this.f39561a = obj;
            this.f39562b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.install(this.f39561a, this.f39562b);
        }
    }

    /* loaded from: classes5.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39564a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39565b;

        c(Object obj, String str) {
            this.f39564a = obj;
            this.f39565b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.notifyCloseBtn(this.f39564a, this.f39565b);
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39567a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39568b;

        d(Object obj, String str) {
            this.f39567a = obj;
            this.f39568b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.toggleCloseBtn(this.f39567a, this.f39568b);
        }
    }

    /* loaded from: classes5.dex */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39571b;

        e(Object obj, String str) {
            this.f39570a = obj;
            this.f39571b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.getEndScreenInfo(this.f39570a, this.f39571b);
        }
    }

    /* loaded from: classes5.dex */
    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39573a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39574b;

        f(Object obj, String str) {
            this.f39573a = obj;
            this.f39574b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.setOrientation(this.f39573a, this.f39574b);
        }
    }

    /* loaded from: classes5.dex */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39576a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39577b;

        g(Object obj, String str) {
            this.f39576a = obj;
            this.f39577b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.handlerPlayableException(this.f39576a, this.f39577b);
        }
    }

    /* loaded from: classes5.dex */
    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39580b;

        h(Object obj, String str) {
            this.f39579a = obj;
            this.f39580b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.openURL(this.f39579a, this.f39580b);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        if (t0.h()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.f39557h.post(new a(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        if (t0.h()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.f39557h.post(new g(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        if (t0.h()) {
            super.install(obj, str);
        } else {
            this.f39557h.post(new b(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        if (t0.h()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.f39557h.post(new c(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        if (t0.h()) {
            super.openURL(obj, str);
        } else {
            this.f39557h.post(new h(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        if (t0.h()) {
            super.setOrientation(obj, str);
        } else {
            this.f39557h.post(new f(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        if (t0.h()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.f39557h.post(new d(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        if (t0.h()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.f39557h.post(new e(obj, str));
        }
    }
}
