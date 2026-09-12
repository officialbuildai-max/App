package com.transsion.baseui.util;

import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R$layout;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import uh.b;

/* loaded from: classes5.dex */
public abstract class m {
    public static final void a(int i11) {
        try {
            Result.Companion companion = Result.INSTANCE;
            b.a aVar = uh.b.f76876a;
            int i12 = R$layout.base_layout_new_info_toast;
            String string = Utils.a().getString(i11);
            Intrinsics.g(string, "getString(...)");
            aVar.g(i12, string, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void b(String str) {
        Intrinsics.h(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            uh.b.f76876a.g(R$layout.base_layout_new_info_toast, str, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void c(int i11) {
        try {
            Result.Companion companion = Result.INSTANCE;
            b.a aVar = uh.b.f76876a;
            int i12 = R$layout.base_layout_new_success_toast;
            String string = Utils.a().getString(i11);
            Intrinsics.g(string, "getString(...)");
            aVar.g(i12, string, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void d(String str) {
        Intrinsics.h(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            uh.b.f76876a.g(R$layout.base_layout_new_success_toast, str, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void e(int i11) {
        try {
            Result.Companion companion = Result.INSTANCE;
            b.a aVar = uh.b.f76876a;
            int i12 = R$layout.base_layout_new_warn_toast;
            String string = Utils.a().getString(i11);
            Intrinsics.g(string, "getString(...)");
            aVar.g(i12, string, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void f(String str) {
        Intrinsics.h(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            uh.b.f76876a.g(R$layout.base_layout_new_warn_toast, str, (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }
}
