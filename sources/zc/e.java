package zc;

import android.util.Log;
import bd.f;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private com.google.firebase.remoteconfig.internal.e f79531a;

    /* renamed from: b, reason: collision with root package name */
    private a f79532b;

    /* renamed from: c, reason: collision with root package name */
    private Executor f79533c;

    /* renamed from: d, reason: collision with root package name */
    private Set f79534d = Collections.newSetFromMap(new ConcurrentHashMap());

    public e(com.google.firebase.remoteconfig.internal.e eVar, a aVar, Executor executor) {
        this.f79531a = eVar;
        this.f79532b = aVar;
        this.f79533c = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Task task, final f fVar, com.google.firebase.remoteconfig.internal.f fVar2) {
        try {
            com.google.firebase.remoteconfig.internal.f fVar3 = (com.google.firebase.remoteconfig.internal.f) task.getResult();
            if (fVar3 != null) {
                final bd.e b11 = this.f79532b.b(fVar3);
                this.f79533c.execute(new Runnable() { // from class: zc.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.this.a(b11);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e11) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e11);
        }
    }

    public void g(com.google.firebase.remoteconfig.internal.f fVar) {
        try {
            final bd.e b11 = this.f79532b.b(fVar);
            for (final f fVar2 : this.f79534d) {
                this.f79533c.execute(new Runnable() { // from class: zc.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.this.a(b11);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e11) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e11);
        }
    }

    public void h(final f fVar) {
        this.f79534d.add(fVar);
        final Task e11 = this.f79531a.e();
        e11.addOnSuccessListener(this.f79533c, new OnSuccessListener() { // from class: zc.c
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                e.this.f(e11, fVar, (com.google.firebase.remoteconfig.internal.f) obj);
            }
        });
    }
}
