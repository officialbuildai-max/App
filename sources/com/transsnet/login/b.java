package com.transsnet.login;

import com.blankj.utilcode.util.ThreadUtils;
import com.transsnet.login.b;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f60406a = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i11) {
            uh.b.f76876a.d(i11);
        }

        public final void b(final int i11) {
            ThreadUtils.g().postDelayed(new Runnable() { // from class: com.transsnet.login.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.c(i11);
                }
            }, 500L);
        }
    }
}
