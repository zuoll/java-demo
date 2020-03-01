package com.zll.demo.Service;

import com.zll.demo.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @see Mono
 * @see Flux
 */
@Service
public class UserService {

    private static final Map<String, User> data = new ConcurrentHashMap<>();

    /**
     * 获取所有的列表
     *
     * @return
     */
    public Flux<User> list() {
        return Flux.fromIterable(this.data.values());
    }

    /**
     * 通过ids查找所有的列表
     *
     * @param ids
     * @return
     */
    public Flux<User> getByIds(final Flux<String> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }


    /**
     * 通过id 查询一个对象
     *
     * @return
     */
    public Mono<User> getById(final String id) {
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new RuntimeException("user not exist!")));
    }

    /**
     * 添加或者更新一个用户
     *
     * @return
     */
    public Mono<User> saveOrUpdate(final User user) {
        this.data.put(user.getUuid(), user);
        return Mono.just(user);
    }

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    public Mono<User> deleteUser(final String id) {
        return Mono.justOrEmpty(this.data.remove(id));
    }


}
