package com.transsion.baselib.report;

import android.os.Bundle;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsnet.loginapi.ILoginApi;
import java.util.HashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
public final class j implements hj.j {

    /* renamed from: c, reason: collision with root package name */
    private ILoginApi f43410c;

    /* renamed from: d, reason: collision with root package name */
    private IMemberApi f43411d;

    /* renamed from: a, reason: collision with root package name */
    private HashSet f43408a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final String f43409b = "ext";

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f43412e = LazyKt.b(new Function0() { // from class: com.transsion.baselib.report.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IPremiumApi e11;
            e11 = j.e();
            return e11;
        }
    });

    public j() {
        this.f43408a.add(AppStartDotState.APP_START);
        this.f43408a.add("app_stop");
        this.f43408a.add("download_click");
    }

    private final native IPremiumApi d();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native IPremiumApi e();

    @Override // hj.j
    public native Bundle a(String str, Bundle bundle);

    @Override // hj.j
    public native void b(String str, String str2, Map map);

    @Override // hj.j
    public native Pair getAccount();
}
