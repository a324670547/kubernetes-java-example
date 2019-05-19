package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1ReplicationController;
import io.kubernetes.client.models.V1ReplicationControllerList;

/**
 * - 描述：获取 ReplicationController
 * - API版本： v1
 */
public class GetReplicationController {

    /**
     * 获取全部 Namespace 的 ReplicationController 列表
     */
    public static void getAllReplication() throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 下的 ReplicationController 列表
        V1ReplicationControllerList replicationControllerList = api.listReplicationControllerForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1ReplicationController item : replicationControllerList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 ReplicationController 列表
     */
    public static void getNamespaceReplicationList(String namespace) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 的 replicationControllerController 列表
        V1ReplicationControllerList replicationControllerList = api.listNamespacedReplicationController(namespace, null, null, null, null, null, null, null, null,null);
        for (V1ReplicationController item : replicationControllerList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 replicationControllerController
     */
    public static void getNamespaceReplication(String namespace,String replicationName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 的某个 replicationControllerController
        V1ReplicationController replicationController = api.readNamespacedReplicationController(replicationName, namespace, null, null,null);
        System.out.println(replicationController);
    }

    /**
     * 获取 replicationControllerController
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 ReplicationController
        getAllReplication();
        // 获取 Kubernetes 集群的 Replication 信息
        getNamespaceReplicationList("namespace");
        // 获取某个 Namespace 的某个 Replication
        getNamespaceReplication("namespace","replicationName");
    }

}
