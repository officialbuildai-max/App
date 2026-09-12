package mn;

import androidx.room.RoomDatabase;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.mpush.api.PermanentPushMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class o implements j {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69773a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69774b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f69775c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `permanent_push_message` (`id`,`deeplink`,`subject_id`,`image`,`title`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PermanentPushMessage permanentPushMessage) {
            eVar.c(1, permanentPushMessage.getId());
            if (permanentPushMessage.getDeeplink() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, permanentPushMessage.getDeeplink());
            }
            if (permanentPushMessage.getSubjectId() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, permanentPushMessage.getSubjectId());
            }
            if (permanentPushMessage.getImage() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, permanentPushMessage.getImage());
            }
            if (permanentPushMessage.getTitle() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, permanentPushMessage.getTitle());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `permanent_push_message` WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PermanentPushMessage permanentPushMessage) {
            eVar.c(1, permanentPushMessage.getId());
        }
    }

    public o(RoomDatabase roomDatabase) {
        this.f69773a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object h(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM permanent_push_message");
        try {
            D0.A0();
            D0.close();
            return null;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object i(PermanentPushMessage permanentPushMessage, z3.b bVar) {
        this.f69775c.c(bVar, permanentPushMessage);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM permanent_push_message");
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "deeplink");
            int d13 = androidx.room.util.k.d(D0, "subject_id");
            int d14 = androidx.room.util.k.d(D0, "image");
            int d15 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new PermanentPushMessage((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object k(List list, z3.b bVar) {
        this.f69774b.c(bVar, list);
        return null;
    }

    @Override // mn.j
    public void a(final PermanentPushMessage permanentPushMessage) {
        permanentPushMessage.getClass();
        androidx.room.util.b.d(this.f69773a, false, true, new Function1() { // from class: mn.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object i11;
                i11 = o.this.i(permanentPushMessage, (z3.b) obj);
                return i11;
            }
        });
    }

    @Override // mn.j
    public void b(final List list) {
        list.getClass();
        androidx.room.util.b.d(this.f69773a, false, true, new Function1() { // from class: mn.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object k11;
                k11 = o.this.k(list, (z3.b) obj);
                return k11;
            }
        });
    }

    @Override // mn.j
    public void clear() {
        androidx.room.util.b.d(this.f69773a, false, true, new Function1() { // from class: mn.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object h11;
                h11 = o.h((z3.b) obj);
                return h11;
            }
        });
    }

    @Override // mn.j
    public List getAll() {
        return (List) androidx.room.util.b.d(this.f69773a, true, false, new Function1() { // from class: mn.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List j11;
                j11 = o.j((z3.b) obj);
                return j11;
            }
        });
    }
}
