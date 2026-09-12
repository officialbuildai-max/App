package com.transsion.transfer.impl.client;

import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.entity.FileData;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class o {

    /* renamed from: r, reason: collision with root package name */
    public static final a f55848r = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final AsyncHttpClient f55849a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55850b;

    /* renamed from: c, reason: collision with root package name */
    private final String f55851c;

    /* renamed from: d, reason: collision with root package name */
    private final String f55852d;

    /* renamed from: e, reason: collision with root package name */
    private final com.transsion.transfer.impl.f f55853e;

    /* renamed from: f, reason: collision with root package name */
    private final Function2 f55854f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f55855g;

    /* renamed from: h, reason: collision with root package name */
    private com.transsion.transfer.androidasync.future.f f55856h;

    /* renamed from: i, reason: collision with root package name */
    private long f55857i;

    /* renamed from: j, reason: collision with root package name */
    private final List f55858j;

    /* renamed from: k, reason: collision with root package name */
    private final List f55859k;

    /* renamed from: l, reason: collision with root package name */
    private final List f55860l;

    /* renamed from: m, reason: collision with root package name */
    private final List f55861m;

    /* renamed from: n, reason: collision with root package name */
    private final Map f55862n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f55863o;

    /* renamed from: p, reason: collision with root package name */
    private Long f55864p;

    /* renamed from: q, reason: collision with root package name */
    private final c f55865q;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends AsyncHttpClient.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileData f55867b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f55868c;

        b(FileData fileData, long j11) {
            this.f55867b = fileData;
            this.f55868c = j11;
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, dv.b
        public void a(com.transsion.transfer.androidasync.http.k kVar, long j11, long j12) {
            if (o.this.f55855g && kVar != null) {
                kVar.close();
            }
            super.a(kVar, j11, j12);
            if (System.currentTimeMillis() - o.this.f55857i < 2000) {
                return;
            }
            o.this.f55857i = System.currentTimeMillis();
            com.transsion.transfer.impl.f fVar = o.this.f55853e;
            String fileRemotePath = this.f55867b.getFileRemotePath();
            long j13 = this.f55868c;
            fVar.B(fileRemotePath, j11 + j13, j12 + j13);
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, dv.b
        public void b(com.transsion.transfer.androidasync.http.k kVar) {
            o.this.f55853e.I(this.f55867b.getFileRemotePath(), TaskState.TRANSFERRING, this.f55868c, this.f55867b.getFileSize(), 0L, null);
        }

        @Override // bv.g
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, File file) {
            o.this.f55863o = false;
            o.this.f55865q.a(this.f55867b, kVar != null ? Integer.valueOf(kVar.b()) : null, exc);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements Function3 {
        c() {
        }

        public void a(FileData data, Integer num, Exception exc) {
            Object obj;
            Intrinsics.h(data, "data");
            long currentTimeMillis = System.currentTimeMillis();
            Long l11 = o.this.f55864p;
            long longValue = currentTimeMillis - (l11 != null ? l11.longValue() : 0L);
            Object obj2 = null;
            o.this.f55864p = null;
            if (exc == null) {
                IntRange intRange = new IntRange(200, 299);
                if (num != null && intRange.o(num.intValue())) {
                    Iterator it = o.this.f55859k.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.c(((FileData) next).getFileRemotePath(), data.getFileRemotePath())) {
                            obj2 = next;
                            break;
                        }
                    }
                    FileData fileData = (FileData) obj2;
                    if (fileData != null) {
                        File finalFile = fileData.getFinalFile();
                        o.this.f55859k.remove(fileData);
                        if (fileData.verifyFile()) {
                            jv.e eVar = new jv.e(fileData);
                            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                            String name = jv.e.class.getName();
                            Intrinsics.g(name, "getName(...)");
                            flowEventBus.postEvent(name, eVar, 0L);
                            o.this.f55861m.add(fileData);
                            o.this.f55853e.I(fileData.getFileRemotePath(), TaskState.FINISH, finalFile.length(), fileData.getFileSize(), longValue, null);
                            Function2 function2 = o.this.f55854f;
                            List list = o.this.f55861m;
                            ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(((FileData) it2.next()).getFileRemotePath());
                            }
                            function2.invoke(CollectionsKt.U0(arrayList), Boolean.valueOf(o.this.f55858j.isEmpty()));
                        } else {
                            Integer num2 = (Integer) o.this.f55862n.get(fileData.getFileRemotePath());
                            int intValue = num2 != null ? num2.intValue() : 0;
                            if (intValue > 1) {
                                o.this.f55853e.I(fileData.getFileRemotePath(), TaskState.ERROR, fileData.getDownloadedSize(), fileData.getFileSize(), longValue, "verify file failed");
                                long fileSize = fileData.getFileSize();
                                long length = finalFile.length();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("invoke: verify file fail，fileSize:");
                                sb2.append(fileSize);
                                sb2.append(", saveFile.size:");
                                sb2.append(length);
                                sb2.append(", and delete cache file ,and retry");
                                fileData.clearFile();
                            } else {
                                o.this.f55862n.put(fileData.getFileRemotePath(), Integer.valueOf(intValue + 1));
                                o.this.f55859k.add(fileData);
                            }
                        }
                    }
                    o.this.r();
                }
            }
            Iterator it3 = o.this.f55859k.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it3.next();
                    if (Intrinsics.c(((FileData) obj).getFileRemotePath(), data.getFileRemotePath())) {
                        break;
                    }
                }
            }
            FileData fileData2 = (FileData) obj;
            if (fileData2 != null) {
                o oVar = o.this;
                oVar.f55859k.remove(fileData2);
                oVar.f55860l.add(fileData2);
                oVar.f55853e.I(fileData2.getFileRemotePath(), (num != null && num.intValue() == 404) ? TaskState.NO_FILE : TaskState.ERROR, new File(fileData2.getFileReceiveCachePath()).length(), fileData2.getFileSize(), longValue, "errorCode:" + num + ", errorMsg:" + (exc != null ? exc.getMessage() : null));
            }
            if (exc != null) {
                exc.printStackTrace();
            }
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("invoke: send file error:");
            sb3.append(message);
            sb3.append(", skip it and send next");
            o.this.r();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((FileData) obj, (Integer) obj2, (Exception) obj3);
            return Unit.f67184a;
        }
    }

    public o(AsyncHttpClient httpClient, String clientIp, String transferId, String urlPath, com.transsion.transfer.impl.f listener, Function2 completeListener) {
        Intrinsics.h(httpClient, "httpClient");
        Intrinsics.h(clientIp, "clientIp");
        Intrinsics.h(transferId, "transferId");
        Intrinsics.h(urlPath, "urlPath");
        Intrinsics.h(listener, "listener");
        Intrinsics.h(completeListener, "completeListener");
        this.f55849a = httpClient;
        this.f55850b = clientIp;
        this.f55851c = transferId;
        this.f55852d = urlPath;
        this.f55853e = listener;
        this.f55854f = completeListener;
        this.f55858j = new ArrayList();
        this.f55859k = new ArrayList();
        this.f55860l = new ArrayList();
        this.f55861m = new ArrayList();
        this.f55862n = new LinkedHashMap();
        this.f55864p = 0L;
        this.f55865q = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (this.f55855g) {
            return;
        }
        if (this.f55859k.isEmpty() && !this.f55858j.isEmpty()) {
            this.f55859k.add(this.f55858j.remove(0));
        }
        if (this.f55859k.isEmpty() || this.f55863o) {
            return;
        }
        s((FileData) this.f55859k.get(0));
    }

    private final void s(FileData fileData) {
        File parentFile = new File(fileData.getFileReceiveCachePath()).getParentFile();
        if ((parentFile != null ? parentFile.getFreeSpace() : 0L) < fileData.getFileSize()) {
            this.f55853e.I(fileData.getFileRemotePath(), TaskState.SPACE_LIMIT, 0L, fileData.getFileSize(), 0L, null);
            this.f55859k.remove(fileData);
            r();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("receiveFile:start:");
        sb2.append(fileData);
        sb2.append(" ");
        this.f55863o = true;
        FileData.Companion companion = FileData.INSTANCE;
        TaskState taskState = TaskState.CONNECTING;
        fileData.setState(companion.a(taskState));
        fileData.filePrepare();
        File tempFile = fileData.getTempFile();
        File tempBackFile = tempFile.exists() ? fileData.getTempBackFile() : tempFile;
        long length = tempFile.exists() ? tempFile.length() : 0L;
        this.f55864p = Long.valueOf(System.currentTimeMillis());
        this.f55853e.I(fileData.getFileRemotePath(), taskState, length, fileData.getFileSize(), 0L, null);
        AsyncHttpClient asyncHttpClient = this.f55849a;
        com.transsion.transfer.androidasync.http.h c11 = TransferClient.f55788t.c(this.f55852d + "/client/fetchFile?file=" + jv.a.b(fileData.getFileRemotePath()), this.f55850b, this.f55851c);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("transferFile: bytes=");
        sb3.append(length);
        sb3.append("-");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("transferFile: fileData=");
        sb4.append(fileData);
        c11.h().a("Range", "bytes=" + length + "-");
        Unit unit = Unit.f67184a;
        this.f55856h = asyncHttpClient.t(c11, tempBackFile.getAbsolutePath(), new b(fileData, length));
    }

    public final void p(List files) {
        Object obj;
        Object obj2;
        Intrinsics.h(files, "files");
        this.f55855g = false;
        ArrayList arrayList = new ArrayList();
        List<FileData> list = files;
        for (FileData fileData : list) {
            Iterator it = this.f55859k.iterator();
            while (true) {
                obj = null;
                if (it.hasNext()) {
                    obj2 = it.next();
                    if (Intrinsics.c(fileData.getFileRemotePath(), ((FileData) obj2).getFileRemotePath())) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            if (obj2 == null) {
                Iterator it2 = this.f55858j.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (Intrinsics.c(fileData.getFileRemotePath(), ((FileData) next).getFileRemotePath())) {
                        obj = next;
                        break;
                    }
                }
                if (obj != null) {
                }
            }
            arrayList.add(fileData);
        }
        if (!arrayList.isEmpty()) {
            files.removeAll(arrayList);
        }
        List list2 = this.f55858j;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(list2, 10)), 16));
        for (Object obj3 : list2) {
            linkedHashMap.put(((FileData) obj3).getFileRemotePath(), obj3);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(list, 10)), 16));
        for (Object obj4 : list) {
            linkedHashMap2.put(((FileData) obj4).getFileRemotePath(), obj4);
        }
        List R0 = CollectionsKt.R0(MapsKt.o(linkedHashMap, linkedHashMap2).values());
        this.f55858j.clear();
        this.f55858j.addAll(R0);
        r();
    }

    public final void q() {
        com.transsion.transfer.androidasync.future.f fVar = this.f55856h;
        if (fVar != null) {
            fVar.cancel(true);
        }
        this.f55855g = true;
        this.f55859k.clear();
        this.f55858j.clear();
        this.f55861m.clear();
        this.f55860l.clear();
        this.f55862n.clear();
    }

    public final void t(FileData fileData) {
        if (fileData != null) {
            if (!this.f55859k.contains(fileData)) {
                this.f55858j.remove(fileData);
            }
            this.f55859k.remove(fileData);
            this.f55859k.add(0, fileData);
        }
        r();
    }
}
