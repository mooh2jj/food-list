package foodlist.demo.wishlist.repository;

import foodlist.demo.db.MemoryDbRepositoyAbstract;
import foodlist.demo.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WishListRepository extends MemoryDbRepositoyAbstract<WishListEntity> {

}
