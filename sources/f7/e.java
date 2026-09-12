package f7;

import android.graphics.Color;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f62475e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f62476a;

    /* renamed from: b, reason: collision with root package name */
    private final int f62477b;

    /* renamed from: c, reason: collision with root package name */
    private final float f62478c;

    /* renamed from: d, reason: collision with root package name */
    private Function0 f62479d;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(String title, Function0 function0) {
            Intrinsics.h(title, "title");
            return new e(title, Color.parseColor("#FF007AFF"), 16.0f, function0);
        }
    }

    public e(String title, int i11, float f11, Function0 function0) {
        Intrinsics.h(title, "title");
        this.f62476a = title;
        this.f62477b = i11;
        this.f62478c = f11;
        this.f62479d = function0;
    }

    public final Function0 a() {
        return this.f62479d;
    }

    public final int b() {
        return this.f62477b;
    }

    public final float c() {
        return this.f62478c;
    }

    public final String d() {
        return this.f62476a;
    }

    public final void e(Function0 function0) {
        this.f62479d = function0;
    }
}
