package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class u implements UGCCollectionVideoGroupDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43279a;

    /* renamed from: c, reason: collision with root package name */
    private final ij.b f43281c = new ij.b();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43280b = new a();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `ugc_collection_video_group` (`collectionId`,`ugcVideoIds`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, UGCCollectionVideoGroup uGCCollectionVideoGroup) {
            if (uGCCollectionVideoGroup.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, uGCCollectionVideoGroup.getCollectionId());
            }
            String a11 = u.this.f43281c.a(uGCCollectionVideoGroup.getUgcVideoIds());
            if (a11 == null) {
                eVar.g(2);
            } else {
                eVar.j(2, a11);
            }
        }
    }

    public u(RoomDatabase roomDatabase) {
        this.f43279a = roomDatabase;
    }

    public static List j() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List k(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM ugc_collection_video_group");
        try {
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoIds");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String str = null;
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                if (!D0.isNull(d12)) {
                    str = D0.n0(d12);
                }
                arrayList.add(new UGCCollectionVideoGroup(n02, this.f43281c.b(str)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ UGCCollectionVideoGroup l(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM ugc_collection_video_group WHERE collectionId = ? LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoIds");
            UGCCollectionVideoGroup uGCCollectionVideoGroup = null;
            String n02 = null;
            if (D0.A0()) {
                String n03 = D0.isNull(d11) ? null : D0.n0(d11);
                if (!D0.isNull(d12)) {
                    n02 = D0.n0(d12);
                }
                uGCCollectionVideoGroup = new UGCCollectionVideoGroup(n03, this.f43281c.b(n02));
            }
            D0.close();
            return uGCCollectionVideoGroup;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(UGCCollectionVideoGroup uGCCollectionVideoGroup, z3.b bVar) {
        this.f43280b.d(bVar, uGCCollectionVideoGroup);
        return Unit.f67184a;
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object a(String str, List list, Continuation continuation) {
        return UGCCollectionVideoGroupDao.DefaultImpls.a(this, str, list, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object b(final UGCCollectionVideoGroup uGCCollectionVideoGroup, Continuation continuation) {
        uGCCollectionVideoGroup.getClass();
        return androidx.room.util.b.f(this.f43279a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = u.this.m(uGCCollectionVideoGroup, (z3.b) obj);
                return m11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object c(String str, Continuation continuation) {
        return UGCCollectionVideoGroupDao.DefaultImpls.b(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43279a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCCollectionVideoGroup l11;
                l11 = u.this.l(str, (z3.b) obj);
                return l11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object e(Continuation continuation) {
        return androidx.room.util.b.f(this.f43279a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List k11;
                k11 = u.this.k((z3.b) obj);
                return k11;
            }
        }, continuation);
    }
}
