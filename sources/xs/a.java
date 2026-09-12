package xs;

import android.view.View;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.Subject;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0991a f78549g = new C0991a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f78550a;

    /* renamed from: b, reason: collision with root package name */
    private final View f78551b;

    /* renamed from: c, reason: collision with root package name */
    private final Subject f78552c;

    /* renamed from: d, reason: collision with root package name */
    private final OperateItem f78553d;

    /* renamed from: e, reason: collision with root package name */
    private final int f78554e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f78555f;

    /* renamed from: xs.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0991a {
        private C0991a() {
        }

        public /* synthetic */ C0991a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i11, View view, Subject subject, OperateItem operateItem, int i12, boolean z10) {
        this.f78550a = i11;
        this.f78551b = view;
        this.f78552c = subject;
        this.f78553d = operateItem;
        this.f78554e = i12;
        this.f78555f = z10;
    }

    public /* synthetic */ a(int i11, View view, Subject subject, OperateItem operateItem, int i12, boolean z10, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? null : view, (i13 & 4) != 0 ? null : subject, (i13 & 8) == 0 ? operateItem : null, (i13 & 16) != 0 ? 0 : i12, (i13 & 32) == 0 ? z10 : false);
    }

    public final OperateItem a() {
        return this.f78553d;
    }

    public final Subject b() {
        return this.f78552c;
    }

    public final int c() {
        return this.f78554e;
    }

    public final int d() {
        return this.f78550a;
    }

    public final View e() {
        return this.f78551b;
    }

    public final boolean f() {
        return this.f78555f;
    }
}
