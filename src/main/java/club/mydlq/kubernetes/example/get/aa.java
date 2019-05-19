package club.mydlq.kubernetes.example.get;

public class aa {

    /**
     *
     * 查询或者观察 Kubernetes 集群全部 Namespace
     * @param includeUninitialized 如果为 true，则响应中包含部分初始化的资源。(可选)
     * @param pretty @param pretty 如果“true”，那么输出就会被打印出来。(可选)
     * @param _continue 从服务器检索更多结果时设置 continue 选项。由于此值是服务器定义的，客户端只
     *                  能使用具有相同查询参数的前一个查询结果的 continue 值(continue值除外)，服务器可
     *                  能拒绝不认识的 continue 值。如果指定的 continue 值不再有效，无论是由于过期(通常
     *                  是5到15分钟)还是服务器上的配置更改，服务器将响应 410 ResourceExpired 错误和一个
     *                  continue 令牌。如果客户机需要一致的列表，则必须在不使用 continue 字段的情况下重新
     *                  启动列表。否则,客户端可以发送另一个列表请求令牌收到410错误,服务器将响应列表从下一个键,
     *                  但从最新的快照,从前面的列表不一致的结果——对象创建、修改或删除后第一个列表请求将被包含
     *                  在响应,只要他们的钥匙后,\“\“下一个关键。当 watch 为 true 时不支持此字段。客户端可以
     *                  从服务器返回的最后一个resource eversion值开始监视，并且不会错过任何修改。(可选)     * @param fieldSelector field 选择器，用于根据返回对象中的 field 限制其列表。默认为一切。(可选)
     * @param labelSelector label 选择器，用于根据返回对象的 label 限制它们的列表。默认为一切。(可选)
     * @param limit limit 是返回列表调用的最大响应数。如果查询的结果超过 limit 限制，那么服务器将设置 “continue”
     *              将列表 metadata 中的字段设置为一个值，该值可与相同的初始查询一起使用，以检索下一组结果。如果所
     *              有被请求的对象都被过滤掉，并且客户端应该只使用 continue 字段的存在来确定是否有更多的结果可用，
     *              那么设置一个限制可能会返回比请求数量少的项(最多为零项)。服务器可能选择不支持 limit 参数，并返
     *              回所有可用的结果。如果指定了 limit，并且 continue 字段为 null，客户端可能会假设没有更多的结
     *              果可用。如果 watch 为 true，则不支持此字段。服务器保证在使用 continue 时返回的对象与不受限制
     *              地发出单个列表调用是相同的——也就是说，在发出第一个请求之后，不会有任何对象被创建、修改或删除。这
     *              有时被称为一致快照，并确保使用 limit 接收非常大的结果的较小块的客户机可以确保它们看到所有可能的
     *              对象。如果在分块列表期间更新对象，则返回计算第一个列表结果时出现的对象的版本。(可选)
     * @param resourceVersion 在使用 watch 调用指定时，显示资源的特定版本之后发生的更改。默认从历史更改开始。当
     *                        为 list 指定时:
     *                          - 如果未设置，则根据quorum-read标志从远程存储返回结果;
     *                          - 如果它是0，那么我们只是返回我们当前在缓存中的东西，没有保证;
     *                          - 如果设置为非0，那么结果至少与给定的rv一样刷新。(可选)
     * @param timeoutSeconds 为 list/watch 调用超时。这限制了调用的持续时间，而不管调用是否处于活动状态。(可选)
     * @param watch 查看对描述的资源的更改，并将其作为添加、更新和删除通知的流返回。指定 resourceVersion。(可选)
     * @return V1NamespaceList
     * @throws ApiException 如果未能调用API，例如服务器错误或无法反序列化响应体，则抛出ApiException
     */
    /*public V1NamespaceList listNamespace(Boolean includeUninitialized, String pretty, String _continue, String fieldSelector, String labelSelector, Integer limit, String resourceVersion, Integer timeoutSeconds, Boolean watch) throws ApiException {
        ApiResponse<V1NamespaceList> resp = listNamespaceWithHttpInfo(includeUninitialized, pretty, _continue, fieldSelector, labelSelector, limit, resourceVersion, timeoutSeconds, watch);
        return resp.getData();
    }*/

}
