package com.transsion.baselib.db.place;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.g;
import androidx.room.util.k;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.baselib.db.place.PlaceDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class d implements PlaceDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43158a;

    /* renamed from: b, reason: collision with root package name */
    private final g f43159b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final e f43160c = new b();

    /* loaded from: classes5.dex */
    class a extends g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `place_list` (`latitude`,`longitude`,`name`,`address`,`distance`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PlaceDBBean placeDBBean) {
            eVar.a(1, placeDBBean.getLatitude());
            eVar.a(2, placeDBBean.getLongitude());
            if (placeDBBean.getName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, placeDBBean.getName());
            }
            if (placeDBBean.getAddress() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, placeDBBean.getAddress());
            }
            if (placeDBBean.getDistance() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, placeDBBean.getDistance());
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `place_list` WHERE `latitude` = ? AND `longitude` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PlaceDBBean placeDBBean) {
            eVar.a(1, placeDBBean.getLatitude());
            eVar.a(2, placeDBBean.getLongitude());
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f43158a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit i(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM place_list");
        try {
            D0.A0();
            return Unit.f67184a;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM place_list");
        try {
            int d11 = k.d(D0, "latitude");
            int d12 = k.d(D0, "longitude");
            int d13 = k.d(D0, "name");
            int d14 = k.d(D0, PlaceTypes.ADDRESS);
            int d15 = k.d(D0, "distance");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new PlaceDBBean(D0.getDouble(d11), D0.getDouble(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(List list, z3.b bVar) {
        this.f43159b.c(bVar, list);
        return Unit.f67184a;
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f43158a, false, true, new Function1() { // from class: com.transsion.baselib.db.place.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i11;
                i11 = d.i((z3.b) obj);
                return i11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.f43158a, false, true, new Function1() { // from class: com.transsion.baselib.db.place.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = d.this.k(list, (z3.b) obj);
                return k11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object c(List list, Continuation continuation) {
        return PlaceDao.DefaultImpls.a(this, list, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.f43158a, true, false, new Function1() { // from class: com.transsion.baselib.db.place.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List j11;
                j11 = d.j((z3.b) obj);
                return j11;
            }
        }, continuation);
    }
}
