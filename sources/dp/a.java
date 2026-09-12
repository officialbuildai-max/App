package dp;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.ui.adapter.i;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: h1, reason: collision with root package name */
    public static final C0759a f61499h1 = C0759a.f61500a;

    /* renamed from: dp.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0759a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0759a f61500a = new C0759a();

        private C0759a() {
        }

        public final a a(Context context, Fragment fragment, RecyclerView recyclerView, i iVar, String pageName, String subpageName, boolean z10) {
            Intrinsics.h(context, "context");
            Intrinsics.h(fragment, "fragment");
            Intrinsics.h(pageName, "pageName");
            Intrinsics.h(subpageName, "subpageName");
            return new e(context, fragment, recyclerView, iVar, pageName, subpageName, z10);
        }
    }

    void a();

    void b();

    void c();

    void onPageDestroy();
}
