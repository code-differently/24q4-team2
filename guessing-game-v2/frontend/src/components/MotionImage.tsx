//import React from 'react';
import { motion } from 'framer-motion';

import logo from '../assets/FunnyBoy.jpg';
//import logo1 from '../assets/gameman.png';
//import logo1 from '../assets/nicebg.jpg';
//import logo from '../assets/number.jpg';

const MotionImage = () => {
  return (
    <motion.div
      initial={{ opacity: 0, scale: 0.5 }}  // Initial state
      animate={{ opacity: 1, scale: 1 }}    // Final state (animation end)
      transition={{ duration: 2 }}          // Duration of the animation
    >
      <img
        src={logo} // Replace with your image URL
        alt="credit to GettyImages for this image"
        style={{ width: '100%', borderRadius: '8px' }}  // Optional styling
      />
    </motion.div>
  );
};

export default MotionImage;
