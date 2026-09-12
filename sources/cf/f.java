package cf;

import com.permissionx.guolindev.dialog.RationaleDialog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final o0 f17234a;

    /* renamed from: b, reason: collision with root package name */
    private final e f17235b;

    public f(o0 pb2, e chainTask) {
        Intrinsics.h(pb2, "pb");
        Intrinsics.h(chainTask, "chainTask");
        this.f17234a = pb2;
        this.f17235b = chainTask;
    }

    public final void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17234a.l(permissions);
    }

    public final void b(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17235b.a(permissions);
    }

    public final void c(List permissions, bf.a dialogInfo) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(dialogInfo, "dialogInfo");
        this.f17234a.O(this.f17235b, false, permissions, dialogInfo);
    }

    public final void d(RationaleDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        this.f17234a.N(this.f17235b, true, dialog);
    }

    public final void e(List permissions, bf.a dialogInfo) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(dialogInfo, "dialogInfo");
        this.f17234a.O(this.f17235b, true, permissions, dialogInfo);
    }
}
