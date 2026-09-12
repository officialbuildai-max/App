package rj;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.util.k;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baselib.db.room.RoomItemBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class e implements rj.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f74663a;

    /* renamed from: b, reason: collision with root package name */
    private final g f74664b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f74665c = new b();

    /* loaded from: classes6.dex */
    class a extends g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `room_table` (`groupId`,`name`,`avatar`,`hasJoin`,`newPostCount`,`description`,`postCount`,`userCount`,`level`,`updateTimeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, RoomItemBean roomItemBean) {
            if (roomItemBean.getGroupId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, roomItemBean.getGroupId());
            }
            if (roomItemBean.getName() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, roomItemBean.getName());
            }
            if (roomItemBean.getAvatar() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, roomItemBean.getAvatar());
            }
            if ((roomItemBean.getHasJoin() == null ? null : Integer.valueOf(roomItemBean.getHasJoin().booleanValue() ? 1 : 0)) == null) {
                eVar.g(4);
            } else {
                eVar.c(4, r0.intValue());
            }
            if (roomItemBean.getNewPostCount() == null) {
                eVar.g(5);
            } else {
                eVar.c(5, roomItemBean.getNewPostCount().longValue());
            }
            if (roomItemBean.getDescription() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, roomItemBean.getDescription());
            }
            if (roomItemBean.getPostCount() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, roomItemBean.getPostCount().longValue());
            }
            if (roomItemBean.getUserCount() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, roomItemBean.getUserCount().longValue());
            }
            if (roomItemBean.getLevel() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, roomItemBean.getLevel());
            }
            eVar.c(10, roomItemBean.getUpdateTimeStamp());
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `room_table` WHERE `groupId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, RoomItemBean roomItemBean) {
            if (roomItemBean.getGroupId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, roomItemBean.getGroupId());
            }
        }
    }

    public e(RoomDatabase roomDatabase) {
        this.f74663a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h(RoomItemBean roomItemBean, z3.b bVar) {
        this.f74665c.c(bVar, roomItemBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List i(z3.b bVar) {
        Boolean valueOf;
        z3.e D0 = bVar.D0("SELECT * FROM ROOM_TABLE ORDER BY updateTimeStamp DESC");
        try {
            int d11 = k.d(D0, "groupId");
            int d12 = k.d(D0, "name");
            int d13 = k.d(D0, "avatar");
            int d14 = k.d(D0, "hasJoin");
            int d15 = k.d(D0, "newPostCount");
            int d16 = k.d(D0, TrackingKey.DESCRIPTION);
            int d17 = k.d(D0, "postCount");
            int d18 = k.d(D0, "userCount");
            int d19 = k.d(D0, PermissionConstant.level);
            int d20 = k.d(D0, "updateTimeStamp");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                Integer valueOf2 = D0.isNull(d14) ? null : Integer.valueOf((int) D0.getLong(d14));
                if (valueOf2 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                }
                arrayList.add(new RoomItemBean(n02, n03, n04, valueOf, D0.isNull(d15) ? null : Long.valueOf(D0.getLong(d15)), D0.isNull(d16) ? null : D0.n0(d16), D0.isNull(d17) ? null : Long.valueOf(D0.getLong(d17)), D0.isNull(d18) ? null : Long.valueOf(D0.getLong(d18)), D0.isNull(d19) ? null : D0.n0(d19), D0.getLong(d20)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit j(RoomItemBean roomItemBean, z3.b bVar) {
        this.f74664b.d(bVar, roomItemBean);
        return Unit.f67184a;
    }

    @Override // rj.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f74663a, true, false, new Function1() { // from class: rj.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List i11;
                i11 = e.i((z3.b) obj);
                return i11;
            }
        }, continuation);
    }

    @Override // rj.a
    public Object b(final RoomItemBean roomItemBean, Continuation continuation) {
        roomItemBean.getClass();
        return androidx.room.util.b.f(this.f74663a, false, true, new Function1() { // from class: rj.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = e.this.j(roomItemBean, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // rj.a
    public Object c(final RoomItemBean roomItemBean, Continuation continuation) {
        roomItemBean.getClass();
        return androidx.room.util.b.f(this.f74663a, false, true, new Function1() { // from class: rj.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h11;
                h11 = e.this.h(roomItemBean, (z3.b) obj);
                return h11;
            }
        }, continuation);
    }
}
