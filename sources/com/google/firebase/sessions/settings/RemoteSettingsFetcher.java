package com.google.firebase.sessions.settings;

import android.net.Uri;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* loaded from: classes4.dex */
public final class RemoteSettingsFetcher implements com.google.firebase.sessions.settings.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f32759d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.sessions.b f32760a;

    /* renamed from: b, reason: collision with root package name */
    private final CoroutineContext f32761b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32762c;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettingsFetcher(com.google.firebase.sessions.b appInfo, CoroutineContext blockingDispatcher, String baseUrl) {
        Intrinsics.h(appInfo, "appInfo");
        Intrinsics.h(blockingDispatcher, "blockingDispatcher");
        Intrinsics.h(baseUrl, "baseUrl");
        this.f32760a = appInfo;
        this.f32761b = blockingDispatcher;
        this.f32762c = baseUrl;
    }

    public /* synthetic */ RemoteSettingsFetcher(com.google.firebase.sessions.b bVar, CoroutineContext coroutineContext, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, coroutineContext, (i11 & 4) != 0 ? "firebase-settings.crashlytics.com" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority(this.f32762c).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f32760a.b()).appendPath("settings").appendQueryParameter("build_version", this.f32760a.a().a()).appendQueryParameter("display_version", this.f32760a.a().f()).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.a
    public Object a(Map map, Function2 function2, Function2 function22, Continuation continuation) {
        Object g11 = i.g(this.f32761b, new RemoteSettingsFetcher$doConfigFetch$2(this, map, function2, function22, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }
}
