package androidx.view.compose;

import androidx.compose.runtime.s1;

/* loaded from: classes.dex */
public abstract class LocalLifecycleOwnerKt {

    /* renamed from: a, reason: collision with root package name */
    private static final s1 f9667a;

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r1 = null;
     */
    static {
        /*
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2b
            java.lang.Class<androidx.lifecycle.u> r1 = androidx.view.u.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L2b
            kotlin.jvm.internal.Intrinsics.e(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "androidx.compose.ui.platform.AndroidCompositionLocals_androidKt"
            java.lang.String r3 = "getLocalLifecycleOwner"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.reflect.Method r1 = r1.getMethod(r3, r0)     // Catch: java.lang.Throwable -> L2b
            java.lang.annotation.Annotation[] r2 = r1.getAnnotations()     // Catch: java.lang.Throwable -> L2b
            int r3 = r2.length     // Catch: java.lang.Throwable -> L2b
            r4 = 0
        L1e:
            if (r4 >= r3) goto L2d
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L2b
            boolean r5 = r5 instanceof kotlin.Deprecated     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L28
        L26:
            r1 = r0
            goto L37
        L28:
            int r4 = r4 + 1
            goto L1e
        L2b:
            r1 = move-exception
            goto L3c
        L2d:
            java.lang.Object r1 = r1.invoke(r0, r0)     // Catch: java.lang.Throwable -> L2b
            boolean r2 = r1 instanceof androidx.compose.runtime.s1     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L26
            androidx.compose.runtime.s1 r1 = (androidx.compose.runtime.s1) r1     // Catch: java.lang.Throwable -> L2b
        L37:
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> L2b
            goto L46
        L3c:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.a(r1)
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)
        L46:
            boolean r2 = kotlin.Result.m1191isFailureimpl(r1)
            if (r2 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r1
        L4e:
            androidx.compose.runtime.s1 r0 = (androidx.compose.runtime.s1) r0
            if (r0 != 0) goto L58
            androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1 r0 = new kotlin.jvm.functions.Function0<androidx.view.u>() { // from class: androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1
                static {
                    /*
                        androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1 r0 = new androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1) androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1.INSTANCE androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.view.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.view.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final androidx.view.u invoke() {
                    /*
                        r2 = this;
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r1 = "CompositionLocal LocalLifecycleOwner not present"
                        r0.<init>(r1)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.view.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1.invoke():androidx.lifecycle.u");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r1 = this;
                        androidx.lifecycle.u r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.view.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1.invoke():java.lang.Object");
                }
            }
            androidx.compose.runtime.s1 r0 = androidx.compose.runtime.CompositionLocalKt.f(r0)
        L58:
            androidx.view.compose.LocalLifecycleOwnerKt.f9667a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.compose.LocalLifecycleOwnerKt.<clinit>():void");
    }

    public static final s1 a() {
        return f9667a;
    }
}
