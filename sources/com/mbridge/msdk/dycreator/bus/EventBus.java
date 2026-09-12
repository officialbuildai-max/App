package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public final class EventBus {

    /* renamed from: o, reason: collision with root package name */
    private static volatile EventBus f34834o;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34846k;

    /* renamed from: n, reason: collision with root package name */
    static ExecutorService f34833n = Executors.newCachedThreadPool();
    public static String TAG = "Event";

    /* renamed from: p, reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f34835p = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f34836a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f34837b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f34838c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal<List<Object>> f34839d = new ThreadLocal<List<Object>>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Object> initialValue() {
            return new ArrayList();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final ThreadLocal<BooleanWrapper> f34840e = new ThreadLocal<BooleanWrapper>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BooleanWrapper initialValue() {
            return new BooleanWrapper();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private String f34841f = "onEvent";

    /* renamed from: g, reason: collision with root package name */
    private final HandlerPoster f34842g = new HandlerPoster(this, Looper.getMainLooper(), 10);

    /* renamed from: h, reason: collision with root package name */
    private final BackgroundPoster f34843h = new BackgroundPoster(this);

    /* renamed from: i, reason: collision with root package name */
    private final AsyncPoster f34844i = new AsyncPoster(this);

    /* renamed from: j, reason: collision with root package name */
    private final SubscriberMethodFinder f34845j = new SubscriberMethodFinder();

    /* renamed from: l, reason: collision with root package name */
    private boolean f34847l = true;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Object> f34848m = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34851a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f34851a = iArr;
            try {
                iArr[ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34851a[ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34851a[ThreadMode.BackgroundThread.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34851a[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BooleanWrapper {

        /* renamed from: a, reason: collision with root package name */
        boolean f34852a;

        BooleanWrapper() {
        }
    }

    /* loaded from: classes5.dex */
    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f34835p;
        synchronized (map) {
            try {
                list = map.get(cls);
                if (list == null) {
                    list = new ArrayList<>();
                    for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        list.add(cls2);
                        a(list, cls2.getInterfaces());
                    }
                    f34835p.put(cls, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return list;
    }

    private void a(Subscription subscription, Object obj, boolean z10) {
        int i11 = AnonymousClass3.f34851a[subscription.f34870b.f34864b.ordinal()];
        if (i11 == 1) {
            a(subscription, obj);
            return;
        }
        if (i11 == 2) {
            if (z10) {
                a(subscription, obj);
                return;
            } else {
                this.f34842g.a(subscription, obj);
                return;
            }
        }
        if (i11 == 3) {
            if (z10) {
                this.f34843h.enqueue(subscription, obj);
                return;
            } else {
                a(subscription, obj);
                return;
            }
        }
        if (i11 == 4) {
            this.f34844i.enqueue(subscription, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + subscription.f34870b.f34864b);
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z10) {
        Object obj2;
        this.f34846k = true;
        Class<?> cls = subscriberMethod.f34865c;
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f34836a.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f34836a.put(cls, copyOnWriteArrayList);
        } else {
            Iterator<Subscription> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.f34863a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List<Class<?>> list = this.f34837b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f34837b.put(obj, list);
        }
        list.add(cls);
        if (z10) {
            synchronized (this.f34838c) {
                obj2 = this.f34838c.get(cls);
            }
            if (obj2 != null) {
                a(subscription, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f34836a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i11 = 0;
            while (i11 < size) {
                if (copyOnWriteArrayList.get(i11).f34869a == obj) {
                    copyOnWriteArrayList.remove(i11);
                    i11--;
                    size--;
                }
                i11++;
            }
        }
    }

    private void a(Object obj, String str, boolean z10) {
        Iterator<SubscriberMethod> it = this.f34845j.a(obj.getClass(), str).iterator();
        while (it.hasNext()) {
            a(obj, it.next(), z10);
        }
    }

    private synchronized void a(Object obj, String str, boolean z10, Class<?> cls, Class<?>... clsArr) {
        try {
            for (SubscriberMethod subscriberMethod : this.f34845j.a(obj.getClass(), str)) {
                if (cls == subscriberMethod.f34865c) {
                    a(obj, subscriberMethod, z10);
                } else if (clsArr != null) {
                    int length = clsArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        if (clsArr[i11] == subscriberMethod.f34865c) {
                            a(obj, subscriberMethod, z10);
                            break;
                        }
                        i11++;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void a(Object obj, boolean z10) throws Error {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                List<Class<?>> a11 = a(cls);
                int size = a11.size();
                boolean z11 = false;
                for (int i11 = 0; i11 < size; i11++) {
                    Class<?> cls2 = a11.get(i11);
                    synchronized (this) {
                        copyOnWriteArrayList = this.f34836a.get(cls2);
                    }
                    if (copyOnWriteArrayList != null) {
                        Iterator<Subscription> it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            a(it.next(), obj, z10);
                        }
                        z11 = true;
                    }
                }
                if (z11) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No subscripers registered for event ");
                sb2.append(cls);
                if (cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class) {
                    return;
                }
                post(new NoSubscriberEvent(this, obj));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        f34835p.clear();
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public static EventBus getDefault() {
        if (f34834o == null) {
            synchronized (EventBus.class) {
                try {
                    if (f34834o == null) {
                        f34834o = new EventBus();
                    }
                } finally {
                }
            }
        }
        return f34834o;
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PendingPost pendingPost) {
        Object obj = pendingPost.f34858a;
        Subscription subscription = pendingPost.f34859b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    void a(Subscription subscription, Object obj) throws Error {
        try {
            subscription.f34870b.f34863a.invoke(subscription.f34869a, obj);
        } catch (IllegalAccessException e11) {
            throw new IllegalStateException("Unexpected exception", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (!(obj instanceof SubscriberExceptionEvent)) {
                if (this.f34847l) {
                    Log.e(TAG, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f34869a.getClass(), cause);
                }
                post(new SubscriberExceptionEvent(this, cause, obj, subscription.f34869a));
                return;
            }
            Log.e(TAG, "SubscriberExceptionEvent subscriber " + subscription.f34869a.getClass() + " threw an exception", cause);
            SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
            Log.e(TAG, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
        }
    }

    public void configureLogSubscriberExceptions(boolean z10) {
        if (this.f34846k) {
            throw new EventBusException("This method must be called before any registration");
        }
        this.f34847l = z10;
    }

    public Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.f34838c) {
            obj = this.f34838c.get(cls);
        }
        return obj;
    }

    public void post(Object obj) {
        List<Object> list = this.f34839d.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.f34840e.get();
        if (booleanWrapper.f34852a) {
            return;
        }
        boolean z10 = Looper.getMainLooper() == Looper.myLooper();
        booleanWrapper.f34852a = true;
        while (!list.isEmpty()) {
            try {
                a(list.remove(0), z10);
            } finally {
                booleanWrapper.f34852a = false;
            }
        }
    }

    public void postSticky(Object obj) {
        post(obj);
        synchronized (this.f34838c) {
            this.f34838c.put(obj.getClass(), obj);
        }
    }

    public void register(Object obj) {
        a(obj, this.f34841f, false);
    }

    public void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f34841f, false, cls, clsArr);
    }

    public void register(Object obj, String str) {
        a(obj, str, false);
    }

    public synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, false, cls, clsArr);
    }

    public void register(String str, Object obj) {
        Map<String, Object> map = this.f34848m;
        if (map != null && map.containsKey(str)) {
            unregister(this.f34848m.get(str));
        }
        this.f34848m.put(str, obj);
        a(obj, this.f34841f, false);
    }

    public void registerSticky(Object obj) {
        a(obj, this.f34841f, true);
    }

    public void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f34841f, true, cls, clsArr);
    }

    public void registerSticky(Object obj, String str) {
        a(obj, str, true);
    }

    public synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, true, cls, clsArr);
    }

    public void release() {
        if (f34834o != null) {
            f34834o = null;
            f34833n = null;
            Map<Class<?>, List<Class<?>>> map = f34835p;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.f34836a;
            if (map2 != null && map2.size() > 0) {
                this.f34836a.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.f34837b;
            if (map3 != null && map3.size() > 0) {
                this.f34837b.clear();
            }
            Map<Class<?>, Object> map4 = this.f34838c;
            if (map4 != null && map4.size() > 0) {
                this.f34838c.clear();
            }
            Map<String, Object> map5 = this.f34848m;
            if (map5 == null || map5.size() <= 0) {
                return;
            }
            this.f34848m.clear();
        }
    }

    public Object removeStickyEvent(Class<?> cls) {
        Object remove;
        synchronized (this.f34838c) {
            remove = this.f34838c.remove(cls);
        }
        return remove;
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.f34838c) {
            try {
                Class<?> cls = obj.getClass();
                if (!obj.equals(this.f34838c.get(cls))) {
                    return false;
                }
                this.f34838c.remove(cls);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void unregister(Object obj) {
        try {
            List<Class<?>> list = this.f34837b.get(obj);
            if (list != null) {
                Iterator<Class<?>> it = list.iterator();
                while (it.hasNext()) {
                    a(obj, it.next());
                }
                this.f34837b.remove(obj);
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void unregister(Object obj, Class<?>... clsArr) {
        try {
            if (clsArr.length == 0) {
                throw new IllegalArgumentException("Provide at least one event class");
            }
            List<Class<?>> list = this.f34837b.get(obj);
            if (list != null) {
                for (Class<?> cls : clsArr) {
                    a(obj, cls);
                    list.remove(cls);
                }
                if (list.isEmpty()) {
                    this.f34837b.remove(obj);
                }
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void unregister(String str) {
        try {
            Map<String, Object> map = this.f34848m;
            if (map != null && map.containsKey(str)) {
                Object remove = this.f34848m.remove(str);
                List<Class<?>> list = this.f34837b.get(remove);
                if (list != null) {
                    Iterator<Class<?>> it = list.iterator();
                    while (it.hasNext()) {
                        a(remove, it.next());
                    }
                    this.f34837b.remove(remove);
                } else {
                    Log.w(TAG, "Subscriber to unregister was not registered before: " + remove.getClass());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
