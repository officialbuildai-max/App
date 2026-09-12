package com.transsion.transfer.impl;

import android.app.Application;
import android.os.Environment;
import androidx.view.LiveData;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.entity.FileData;
import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ClientViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Application f55726b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f55727c;

    /* renamed from: d, reason: collision with root package name */
    private final jv.b f55728d;

    /* renamed from: e, reason: collision with root package name */
    private final jv.b f55729e;

    /* renamed from: f, reason: collision with root package name */
    private final jv.b f55730f;

    /* renamed from: g, reason: collision with root package name */
    private final jv.b f55731g;

    /* renamed from: h, reason: collision with root package name */
    private String f55732h;

    /* renamed from: i, reason: collision with root package name */
    private final a f55733i;

    /* renamed from: j, reason: collision with root package name */
    private final b f55734j;

    /* loaded from: classes6.dex */
    public static final class a implements Function3 {
        a() {
        }

        public void a(String str, boolean z10, String str2) {
            ClientViewModel.this.f55732h = str;
            ClientViewModel.this.f55727c.n(Boolean.valueOf(z10));
            if (z10) {
                return;
            }
            kv.b.f68518a.j(str2, TransferClient.f55788t.k());
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((String) obj, ((Boolean) obj2).booleanValue(), (String) obj3);
            return Unit.f67184a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements f {
        b() {
        }

        @Override // com.transsion.transfer.impl.f
        public void B(String remoteFilePath, long j11, long j12) {
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            ClientViewModel.this.f55730f.n(new Pair(remoteFilePath, new Triple(TaskState.TRANSFERRING, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.f
        public void I(String remoteFilePath, TaskState state, long j11, long j12, long j13, String str) {
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Intrinsics.h(state, "state");
            if (state == TaskState.CONNECTING) {
                kv.b.f68518a.h(remoteFilePath, j12, TransferClient.f55788t.k());
            } else if (state == TaskState.FINISH) {
                kv.b.f68518a.g(remoteFilePath, true, null, j12, j13, TransferClient.f55788t.k());
            } else if (state == TaskState.ERROR || state == TaskState.NO_FILE) {
                kv.b.f68518a.g(remoteFilePath, false, "file no found", j11, j13, TransferClient.f55788t.k());
            }
            ClientViewModel.this.f55730f.n(new Pair(remoteFilePath, new Triple(state, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.f
        public void M() {
            ClientViewModel.this.f55727c.n(Boolean.FALSE);
            kv.b.f68518a.j("normal", TransferClient.f55788t.k());
        }

        @Override // com.transsion.transfer.impl.f
        public void j(int i11) {
            ClientViewModel.this.f55729e.n(Integer.valueOf(i11));
        }

        @Override // com.transsion.transfer.impl.f
        public void o(String remoteFilePath) {
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            ClientViewModel.this.f55730f.n(new Pair(remoteFilePath, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f55726b = application;
        this.f55727c = new androidx.view.b0();
        this.f55728d = new jv.b();
        this.f55729e = new jv.b();
        this.f55730f = new jv.b();
        this.f55731g = new jv.b();
        this.f55733i = new a();
        this.f55734j = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, Exception exc) {
        String message = exc != null ? exc.getMessage() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendServerCreateNotify:  ");
        sb2.append(message);
        function1.invoke(Boolean.valueOf(exc == null));
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(List it) {
        Intrinsics.h(it, "it");
        kv.b.f68518a.m(it.size(), TransferClient.f55788t.k());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(ClientViewModel clientViewModel, Function2 function2, boolean z10, String error) {
        Intrinsics.h(error, "error");
        clientViewModel.f55727c.n(Boolean.valueOf(z10));
        kotlinx.coroutines.k.d(u0.a(clientViewModel), y0.c(), null, new ClientViewModel$connect$2$1(function2, z10, error, null), 2, null);
        return Unit.f67184a;
    }

    private final File m() {
        return new File(Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "transfer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(ClientViewModel clientViewModel, List list, Exception exc) {
        if (exc == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getTransferList: ");
            sb2.append(list);
            clientViewModel.f55728d.n(list);
        } else {
            exc.printStackTrace();
            String message = exc.getMessage();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getTransferList error: ");
            sb3.append(message);
            sb3.append(" ");
        }
        return Unit.f67184a;
    }

    public final void B(Function0 callback) {
        Intrinsics.h(callback, "callback");
        TransferClient.a aVar = TransferClient.f55788t;
        if (!aVar.g()) {
            callback.invoke();
            return;
        }
        e i11 = aVar.i();
        i11.k(this.f55734j);
        i11.b(this.f55733i);
        i11.c(callback);
    }

    public final void C(List files) {
        Intrinsics.h(files, "files");
        if (files.isEmpty()) {
            return;
        }
        TransferClient.a aVar = TransferClient.f55788t;
        if (aVar.g()) {
            e i11 = aVar.i();
            i11.k(this.f55734j);
            i11.b(this.f55733i);
            String absolutePath = m().getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
            i11.i(absolutePath, files, new Function1() { // from class: com.transsion.transfer.impl.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit D;
                    D = ClientViewModel.D((List) obj);
                    return D;
                }
            });
        }
    }

    public final void k(final Function2 function2) {
        TransferClient.a aVar = TransferClient.f55788t;
        if (!aVar.g()) {
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, "no connect info");
            }
        } else {
            e i11 = aVar.i();
            i11.k(this.f55734j);
            i11.b(this.f55733i);
            i11.d(new Function2() { // from class: com.transsion.transfer.impl.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l11;
                    l11 = ClientViewModel.l(ClientViewModel.this, function2, ((Boolean) obj).booleanValue(), (String) obj2);
                    return l11;
                }
            });
        }
    }

    public final LiveData n() {
        return this.f55729e;
    }

    public final LiveData o() {
        return this.f55727c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        super.onCleared();
        TransferClient.a aVar = TransferClient.f55788t;
        if (aVar.g()) {
            e i11 = aVar.i();
            i11.g(this.f55734j);
            i11.b(null);
        }
    }

    public final String p() {
        TransferClient.a aVar = TransferClient.f55788t;
        if (!aVar.g()) {
            return "";
        }
        e i11 = aVar.i();
        i11.k(this.f55734j);
        i11.b(this.f55733i);
        String j11 = i11.j();
        if (j11 != null) {
            this.f55732h = j11;
        }
        return j11;
    }

    public final LiveData q() {
        return this.f55731g;
    }

    public final int r() {
        return mv.a.f70136a.e().size();
    }

    public final void s(boolean z10) {
        mv.a aVar = mv.a.f70136a;
        if (!aVar.h() && !z10) {
            this.f55728d.n(aVar.d());
            return;
        }
        TransferClient.a aVar2 = TransferClient.f55788t;
        if (aVar2.g()) {
            kv.b.f68518a.i(aVar2.k());
            e i11 = aVar2.i();
            i11.k(this.f55734j);
            i11.b(this.f55733i);
            String absolutePath = m().getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
            i11.e(absolutePath, new Function2() { // from class: com.transsion.transfer.impl.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t11;
                    t11 = ClientViewModel.t(ClientViewModel.this, (List) obj, (Exception) obj2);
                    return t11;
                }
            });
        }
    }

    public final LiveData u() {
        return this.f55728d;
    }

    public final LiveData v() {
        return this.f55730f;
    }

    public final int w() {
        mv.a aVar = mv.a.f70136a;
        return aVar.f().size() + aVar.g().size();
    }

    public final boolean x() {
        TransferClient.a aVar = TransferClient.f55788t;
        if (!aVar.g()) {
            return false;
        }
        e i11 = aVar.i();
        i11.k(this.f55734j);
        i11.b(this.f55733i);
        return i11.h();
    }

    public final void y(FileData fileData) {
        Intrinsics.h(fileData, "fileData");
        TransferClient.a aVar = TransferClient.f55788t;
        if (aVar.g()) {
            e i11 = aVar.i();
            i11.k(this.f55734j);
            i11.b(this.f55733i);
            i11.f(fileData);
        }
    }

    public final void z(final Function1 callback) {
        Intrinsics.h(callback, "callback");
        TransferClient.a aVar = TransferClient.f55788t;
        if (aVar.g()) {
            e i11 = aVar.i();
            i11.k(this.f55734j);
            i11.b(this.f55733i);
            i11.a(new Function1() { // from class: com.transsion.transfer.impl.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = ClientViewModel.A(Function1.this, (Exception) obj);
                    return A;
                }
            });
        }
    }
}
