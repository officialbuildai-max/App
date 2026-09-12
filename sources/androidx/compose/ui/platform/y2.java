package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.platform.y2;

/* loaded from: classes.dex */
public interface y2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5959a = a.f5960a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5960a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final y2 f5961b = new y2() { // from class: androidx.compose.ui.platform.x2
            @Override // androidx.compose.ui.platform.y2
            public final Recomposer a(View view) {
                Recomposer b11;
                b11 = y2.a.b(view);
                return b11;
            }
        };

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Recomposer b(View view) {
            return WindowRecomposer_androidKt.c(view, null, null, 3, null);
        }

        public final y2 c() {
            return f5961b;
        }
    }

    Recomposer a(View view);
}
