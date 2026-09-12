package r1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f74127f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static a f74128g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f74129a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f74130b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f74131c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f74132d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f74133e;

    /* renamed from: r1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class HandlerC0927a extends Handler {
        HandlerC0927a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f74135a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList f74136b;

        b(Intent intent, ArrayList arrayList) {
            this.f74135a = intent;
            this.f74136b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f74137a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f74138b;

        /* renamed from: c, reason: collision with root package name */
        boolean f74139c;

        /* renamed from: d, reason: collision with root package name */
        boolean f74140d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f74137a = intentFilter;
            this.f74138b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f74138b);
            sb2.append(" filter=");
            sb2.append(this.f74137a);
            if (this.f74140d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    private a(Context context) {
        this.f74129a = context;
        this.f74133e = new HandlerC0927a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f74127f) {
            try {
                if (f74128g == null) {
                    f74128g = new a(context.getApplicationContext());
                }
                aVar = f74128g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f74130b) {
                try {
                    size = this.f74132d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f74132d.toArray(bVarArr);
                    this.f74132d.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = bVarArr[i11];
                int size2 = bVar.f74136b.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    c cVar = (c) bVar.f74136b.get(i12);
                    if (!cVar.f74140d) {
                        cVar.f74138b.onReceive(this.f74129a, bVar.f74135a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f74130b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f74130b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f74130b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                    String action = intentFilter.getAction(i11);
                    ArrayList arrayList2 = (ArrayList) this.f74131c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f74131c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d(Intent intent) {
        int i11;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        synchronized (this.f74130b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f74129a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z10 = (intent.getFlags() & 8) != 0;
                if (z10) {
                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList3 = (ArrayList) this.f74131c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i12 = 0;
                    while (i12 < arrayList3.size()) {
                        c cVar = (c) arrayList3.get(i12);
                        if (z10) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f74137a);
                        }
                        if (cVar.f74139c) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i11 = i12;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i11 = i12;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = cVar.f74137a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (z10) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f74139c = true;
                                i12 = i11 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : NativeComponentConstants.KEY_COMPONENT_TYPE : "data" : EventConstants.KEY_ACTION : "category"));
                            }
                        }
                        arrayList4 = arrayList;
                        i12 = i11 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i13 = 0; i13 < arrayList5.size(); i13++) {
                            ((c) arrayList5.get(i13)).f74139c = false;
                        }
                        this.f74132d.add(new b(intent, arrayList5));
                        if (!this.f74133e.hasMessages(1)) {
                            this.f74133e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f74130b) {
            try {
                ArrayList arrayList = (ArrayList) this.f74130b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.f74140d = true;
                    for (int i11 = 0; i11 < cVar.f74137a.countActions(); i11++) {
                        String action = cVar.f74137a.getAction(i11);
                        ArrayList arrayList2 = (ArrayList) this.f74131c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.f74138b == broadcastReceiver) {
                                    cVar2.f74140d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f74131c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
