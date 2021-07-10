package foodlist.demo.wishlist.repository;

import foodlist.demo.db.MemoryDbRepositoyAbstract;
import foodlist.demo.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoyAbstract<WishListEntity> {

}
