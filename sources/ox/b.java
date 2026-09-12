package ox;

import androidx.fragment.app.FragmentActivity;
import com.transsion.player.orplayer.g;
import com.transsion.videofloat.manager.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import ox.b;

/* loaded from: classes7.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f72314a = a.f72315a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f72315a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final String f72316b = "pip_permission_dialog";

        /* renamed from: c, reason: collision with root package name */
        private static final String f72317c = "key_video_float_permission";

        /* renamed from: d, reason: collision with root package name */
        private static final Lazy f72318d = LazyKt.b(new Function0() { // from class: ox.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i e11;
                e11 = b.a.e();
                return e11;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final i e() {
            return new i();
        }

        public final String b() {
            return f72317c;
        }

        public final b c() {
            return (b) f72318d.getValue();
        }

        public final String d() {
            return f72316b;
        }
    }

    /* renamed from: ox.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0906b {
        public static /* synthetic */ void a(b bVar, boolean z10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopFloat");
            }
            if ((i11 & 1) != 0) {
                z10 = true;
            }
            bVar.f(z10);
        }
    }

    boolean b(String str);

    boolean c(g gVar);

    void d();

    void e(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4);

    void f(boolean z10);

    void g(FragmentActivity fragmentActivity, px.a aVar, boolean z10, boolean z11, Function1 function1, sx.a aVar2);

    boolean isPlaying();
}
