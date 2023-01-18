public Slousion{
  public bollean isBalanced(TreeNode root){
    if(noot == null){
      return true;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if(Math.abs(root.left) - (root.right) > 1){
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right); 
  }
  
  public void getHeight(TreeNode){
  if(root == null){
    return 0;
    }
  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}
