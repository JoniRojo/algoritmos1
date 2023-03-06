data ABB a = Nil | Node (ABB a) a (ABB a)

insert :: (Ord a) => a -> ABB a -> ABB a
insert a Nil = Node Nil a Nil
insert a (Node hi r hd) | a == r = (Node hi r hd)
                        | a > r  = (Node hi r (insert a hd))
                        | a < r  = (Node (insert a hi) r hd)

search :: (Ord a) => a -> ABB a -> Bool
search a Nil = False
search a (Node hi r hd) | a == r = True
                        | a > r  = search a hd
                        | a < r  = search a hi

remove :: (Num a, Ord a) => a -> ABB a -> ABB a         -- a no solo es ordenable, sino tmb instancia de la clase num
remove a Nil = Nil
remove a (Node Nil r Nil)   | a == r = Nil
                            | otherwise = (Node Nil r Nil)  -- a no esta en el arbol
remove a (Node hi r Nil)    | a == r = hi
                            | a > r = (Node hi r Nil)       -- a no esta en el arbol  
                            | a < r = (remove a hi)
remove a (Node Nil r hd)    | a == r = hd
                            | a > r = (remove a hd)       
                            | a < r = (Node Nil r hd)         -- a no esta en el arbol
remove a (Node hi r hd)     | a == r = (Node hi (minimo hd) (remove (minimo hd) hd))                     
                            | a > r = (Node hi r (remove a hd))
                            | a < r = (Node (remove a hi) r hd)

minimo :: (Ord a) => ABB a -> ABB a     -- _ me da igual si hay Nil o hd
minimo (Node Nil r _) = r
minimo (Node hi r _) = minimo hi

size :: ABB a -> Int
size Nil = 0
size (Node hi a hd) = 1 + size hi + size hd

height :: ABB a -> Int
height Nil = 0
height (Node hi a hd) = 1 + max (height hi) (height hd)

inOrder :: ABB a -> [a]
inOrder Nil = []
inOrder (Node hi r hd) = (inOrder hi) ++ [r] ++ (inOrder hd)

preOrder :: ABB a -> [a]
preOrder Nil = []
preOrder (Node hi r hd) = [r] ++ (preOrder hi) ++ (preOrder hd)

postOrder :: ABB a -> [a]
postOrder Nil = []
postOrder (Node hi r hd) =  (postOrder hi) ++ (postOrder hd) ++ [r]

sorted :: (Ord a) => [a] -> Bool
sorted [] = True
sorted [x] = True
sorted (x:xs) = x < (head xs) && sorted xs

isABB :: (Ord a)=> ABB a -> Bool
isABB Nil = True 
isABB (Node hi a hd)= sorted (inOrder (Node hi a hd))

isBalanced :: ABB a -> Bool
isBalanced Nil = True
isBalanced (Node hi r hd) = height hi == height hd

isFull :: ABB a -> Bool
isFull Nil = True
isFull (Node hi r hd) = isBalanced (Node hi r hd) && isFull hi && isFull hd

left :: ABB a -> ABB a
left Nil = Nil
left (Node hi a hd) = hi

right :: ABB a -> ABB a
right Nil = Nil
right (Node hi a hd) = hd

espejo :: ABB a -> ABB a
espejo Nil = Nil
espejo (Node hi a hd) = Node (espejo hd)  a (espejo hi) 

mapABB :: (a -> b) -> ABB a -> ABB b
mapABB f Nil = Nil
mapABB f (Node hi r hd) = Node (mapABB f hi) (f a) (mapABB f hd)

treeSort :: (Ord a) => [a] -> [a]
treeSort [a] = inOrder.(foldr insert [a])

instance (Show a) => Show (ABB a) where
    show Nil = "[]"
    show (Node hi a hd) = show (inOrder (Node hi a hd))