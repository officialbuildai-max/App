package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* loaded from: classes3.dex */
final class e extends ClientInfo {

    /* renamed from: a, reason: collision with root package name */
    private final ClientInfo.ClientType f24330a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.cct.internal.a f24331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b extends ClientInfo.a {

        /* renamed from: a, reason: collision with root package name */
        private ClientInfo.ClientType f24332a;

        /* renamed from: b, reason: collision with root package name */
        private com.google.android.datatransport.cct.internal.a f24333b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new e(this.f24332a, this.f24333b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(com.google.android.datatransport.cct.internal.a aVar) {
            this.f24333b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(ClientInfo.ClientType clientType) {
            this.f24332a = clientType;
            return this;
        }
    }

    private e(ClientInfo.ClientType clientType, com.google.android.datatransport.cct.internal.a aVar) {
        this.f24330a = clientType;
        this.f24331b = aVar;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public com.google.android.datatransport.cct.internal.a b() {
        return this.f24331b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f24330a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f24330a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            com.google.android.datatransport.cct.internal.a aVar = this.f24331b;
            if (aVar == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f24330a;
        int hashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        com.google.android.datatransport.cct.internal.a aVar = this.f24331b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f24330a + ", androidClientInfo=" + this.f24331b + "}";
    }
}
