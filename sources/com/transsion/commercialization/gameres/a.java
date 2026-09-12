package com.transsion.commercialization.gameres;

import android.content.Context;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.aha.AHAGameResLoader;
import com.transsion.commercialization.gameres.ps.PSGameResLoader;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0614a f43828a = C0614a.f43829a;

    /* renamed from: com.transsion.commercialization.gameres.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0614a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0614a f43829a = new C0614a();

        /* renamed from: com.transsion.commercialization.gameres.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public /* synthetic */ class C0615a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f43830a;

            static {
                int[] iArr = new int[GameInfoType.values().length];
                try {
                    iArr[GameInfoType.AHA.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GameInfoType.PS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f43830a = iArr;
            }
        }

        private C0614a() {
        }

        public final a a(GameInfoType type) {
            Intrinsics.h(type, "type");
            int i11 = C0615a.f43830a[type.ordinal()];
            if (i11 == 1) {
                return new AHAGameResLoader();
            }
            if (i11 == 2) {
                return new PSGameResLoader();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    void a(Context context, String str, String str2, Function1 function1);
}
