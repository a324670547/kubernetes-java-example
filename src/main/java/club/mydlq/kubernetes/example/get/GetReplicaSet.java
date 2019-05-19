package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.AppsV1Api;
import io.kubernetes.client.models.V1ReplicaSetList;
import io.kubernetes.client.models.V1ReplicaSet;

/**
 * - 描述：获取 ReplicationSet
 * - API版本： apps/v1
 */
public class GetReplicaSet {

    /**
     * 获取全部 Namespace 的 ReplicationSet 列表
     */
    public static void getAllReplication() throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取全部 Namespace 下的 replicaSet 列表
        V1ReplicaSetList replicaSetList = appsV1Api.listReplicaSetForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1ReplicaSet item : replicaSetList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 ReplicationSet 列表
     */
    public static void getNamespaceReplicationList(String namespace) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 的 Replication 列表
        V1ReplicaSetList replicaSetList = appsV1Api.listNamespacedReplicaSet(namespace, null, null, null, null, null, null, null, null, null);
        for (V1ReplicaSet item : replicaSetList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Replication
     */
    public static void getNamespaceReplication(String namespace, String replicaSetName) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 的 Replication
        V1ReplicaSet replicaSet = appsV1Api.readNamespacedReplicaSet(replicaSetName, namespace, null, null, null);
        System.out.println(replicaSet);
    }

    /**
     * 获取 ReplicationController
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 ReplicationController
        getAllReplication();
        // 获取 Kubernetes 集群的 Replication 信息
        getNamespaceReplicationList("namespace");
        // 获取某个 Namespace 的某个 Replication
        getNamespaceReplication("namespace", "replicationName");
    }
}
