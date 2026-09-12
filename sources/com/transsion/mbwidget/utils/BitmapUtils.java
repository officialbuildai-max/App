package com.transsion.mbwidget.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blankj.utilcode.util.Utils;
import com.transsion.mbwidget.R$mipmap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class BitmapUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final BitmapUtils f46336a = new BitmapUtils();

    private BitmapUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:17:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(android.content.Context r9, java.lang.String r10, int r11, kotlin.coroutines.Continuation r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$1 r0 = (com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$1 r0 = new com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.L$0
            android.content.Context r2 = (android.content.Context) r2
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Exception -> L35
            goto L69
        L35:
            r12 = move-exception
            r7 = r0
            r0 = r10
            r10 = r2
        L39:
            r2 = r7
            goto L6f
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            kotlin.ResultKt.b(r12)
            r12 = 0
            r7 = r10
            r10 = r9
            r9 = r12
            r12 = r11
            r11 = r7
        L4c:
            r2 = 0
            if (r9 >= r12) goto L98
            kotlinx.coroutines.i0 r4 = kotlinx.coroutines.y0.b()     // Catch: java.lang.Exception -> L6a
            com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$2 r5 = new com.transsion.mbwidget.utils.BitmapUtils$loadImageWithRetry$2     // Catch: java.lang.Exception -> L6a
            r5.<init>(r10, r11, r2)     // Catch: java.lang.Exception -> L6a
            r0.L$0 = r10     // Catch: java.lang.Exception -> L6a
            r0.L$1 = r11     // Catch: java.lang.Exception -> L6a
            r0.I$0 = r12     // Catch: java.lang.Exception -> L6a
            r0.I$1 = r9     // Catch: java.lang.Exception -> L6a
            r0.label = r3     // Catch: java.lang.Exception -> L6a
            java.lang.Object r12 = kotlinx.coroutines.i.g(r4, r5, r0)     // Catch: java.lang.Exception -> L6a
            if (r12 != r1) goto L69
            return r1
        L69:
            return r12
        L6a:
            r2 = move-exception
            r7 = r0
            r0 = r12
            r12 = r2
            goto L39
        L6f:
            int r9 = r9 + r3
            lg.a$a r4 = lg.a.f68962a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "load Bitmap Failed-attempt-"
            r5.append(r6)
            r5.append(r9)
            java.lang.String r6 = " :"
            r5.append(r6)
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "DeskWidget_"
            r4.c(r6, r5, r3)
            if (r9 != r0) goto L95
            r12.printStackTrace()
        L95:
            r12 = r0
            r0 = r2
            goto L4c
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.utils.BitmapUtils.e(android.content.Context, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object f(BitmapUtils bitmapUtils, Context context, String str, int i11, Continuation continuation, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 2;
        }
        return bitmapUtils.e(context, str, i11, continuation);
    }

    public final Bitmap b(int i11) {
        Bitmap decodeResource = BitmapFactory.decodeResource(Utils.a().getResources(), i11);
        Intrinsics.g(decodeResource, "decodeResource(...)");
        return decodeResource;
    }

    public final Bitmap c() {
        return b(R$mipmap.ic_default_cover);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.content.Context r20, java.lang.String r21, int r22, kotlin.coroutines.Continuation r23) {
        /*
            r19 = this;
            r0 = r22
            r1 = r23
            boolean r2 = r1 instanceof com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$1
            if (r2 == 0) goto L19
            r2 = r1
            com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$1 r2 = (com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r19
            goto L20
        L19:
            com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$1 r2 = new com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$1
            r3 = r19
            r2.<init>(r3, r1)
        L20:
            java.lang.Object r1 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r5 = r2.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L3a
            if (r5 != r6) goto L32
            kotlin.ResultKt.b(r1)
            goto L89
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.b(r1)
            if (r21 == 0) goto L9d
            int r1 = r21.length()
            if (r1 != 0) goto L46
            goto L9d
        L46:
            kotlinx.coroutines.i0 r1 = kotlinx.coroutines.y0.b()
            kotlinx.coroutines.n0 r8 = kotlinx.coroutines.o0.a(r1)
            if (r0 > 0) goto L56
            int r0 = com.blankj.utilcode.util.y.e()
        L54:
            r11 = r0
            goto L5f
        L56:
            int r1 = com.blankj.utilcode.util.y.e()
            int r0 = kotlin.ranges.RangesKt.i(r0, r1)
            goto L54
        L5f:
            ej.g r9 = ej.g.f62037a
            r17 = 124(0x7c, float:1.74E-43)
            r18 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r10 = r21
            java.lang.String r0 = ej.g.b(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$bitmap$1 r11 = new com.transsion.mbwidget.utils.BitmapUtils$loadBitmap$bitmap$1
            r1 = r20
            r11.<init>(r1, r0, r7)
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            kotlinx.coroutines.r0 r0 = kotlinx.coroutines.i.b(r8, r9, r10, r11, r12, r13)
            r2.label = r6
            java.lang.Object r1 = r0.i(r2)
            if (r1 != r4) goto L89
            return r4
        L89:
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            if (r1 == 0) goto L9d
            boolean r0 = r1.isRecycled()
            if (r0 != 0) goto L9d
            android.graphics.Bitmap$Config r0 = r1.getConfig()
            if (r0 == 0) goto L9d
            android.graphics.Bitmap r7 = r1.copy(r0, r6)
        L9d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.utils.BitmapUtils.d(android.content.Context, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
